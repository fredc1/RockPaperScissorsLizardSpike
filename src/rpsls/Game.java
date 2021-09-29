package rpsls;

import java.util.Scanner;
/**
 * Game Session Object.
 * Handles control flow of the game as a whole. 
 * Much of the high level functionality in main is implemented by other classes
 * that are fields of Game. This makes design, debugging, and testing modular.
 * Note: close() must be called to prevent memory leaks.
 * @author frederickcunningham
 *
 */
public class Game {
	/**
	 * Factory Method.
	 * 
	 * @param numRounds indicate how may rounds constitute a game.
	 * @param rules indicate the type of game being played.
	 * @return an instance of the Game object.
	 */
	public static Game newGame(int numRounds, Rules rules) {
		Scanner inputScanner = new Scanner(System.in);
		Scoreboard aScoreboard = new Scoreboard(rules);
		StdTalker aTalker = new StdTalker(inputScanner);
		Engine aEngine = new Engine(rules);
		StdThrower aThrower = new StdThrower();
		
		return new Game(aScoreboard, aTalker, aThrower, aEngine, inputScanner, numRounds);
		
	}
	private Game(Scoreboard scoreboard, Talker talker, Thrower thrower, Engine engine, Scanner scanner,int totalNumRounds) {
		this.scoreboard = scoreboard;
		this.talker = talker;
		this.thrower = thrower;
		this.engine = engine;
		this.scanner = scanner;
		this.totalNumRounds = totalNumRounds;
	}
	/**
	 * Gives a welcome message and teaches user to play the game.
	 */
	public void welcomePlayer() {
		talker.welcomeToGame();
		talker.teach();
		talker.askToProceed();
	}
	/**
	 * Initiates the main game loop.
	 * @throws Exception if you try to play the game before ending another.
	 */
	public void play() throws Exception{
		if (scoreboard.isNotEmpty()) {
			Exception e = new Exception("scoreboard is not empty");
			throw e;
		}
		int roundNumber = 0;
		while (roundNumber < totalNumRounds) {
			
			talker.welcomeToRound(roundNumber);
			
			Move aiMove = thrower.getMove();
			Move playerMove = talker.askForMove();
						
			Result result = engine.compareMoves(playerMove,aiMove);
			
			roundNumber++;
			if (result == Result.HUMANWIN) { 
				String announcement = engine.getAnnouncement(playerMove,aiMove);
				talker.revealRoundOutcome(aiMove,announcement);
				talker.congratulate();
			} else if(result == Result.AIWIN) {
				String announcement = engine.getAnnouncement(aiMove,playerMove);
				talker.revealRoundOutcome(aiMove,announcement);
				talker.console();
				
			} else if (result == Result.TIE){ 
				String announcement = engine.getAnnouncement(playerMove,aiMove);
				talker.revealRoundOutcome(aiMove,announcement);
				talker.announceTie();
				roundNumber--;
			}
			
			scoreboard.update(playerMove,aiMove,result);
		}
	}
	/**
	 * Gives final info to user.
	 */
	public void summarize() {
		talker.summarizeGame(scoreboard.toString());
	}
	/**
	 * Closes System.in which prevents another game being played in this process.
	 */
	public void close() {
		this.scanner.close();
	}
	
	private Scoreboard scoreboard;
	private Talker talker;
	private Thrower thrower;
	private Engine engine;
	private Scanner scanner;
	private int totalNumRounds;
	
	

}
