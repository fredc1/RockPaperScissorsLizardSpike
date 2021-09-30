package rpsls;

/**
 * Scoreboard object keeps track of how players perform with which moves.
 * @author frederickcunningham
 *
 */
public class Scoreboard {
	
	/**
	 * Constructor
	 * Uses the rules of the game to structure the board.
	 * @param rules
	 */
	public Scoreboard(Rules rules) {
		this.rules = rules;
		aiScore = 0;
		playerScore = 0;
		roundsSoFar = 0;
		int dim = rules.getMoves().length;
		playerWins = new int[dim];
		playerLosses = new int[dim];
		playerTies = new int[dim];
		aiWins = new int[dim];
		aiLosses = new int[dim];
		aiTies = new int[dim];
	}
	/**
	 * Sets the score according to what has happened in the game
	 * @param playerMove
	 * @param aiMove
	 * @param result
	 */
	public void update(Move playerMove, Move aiMove, Result result) {
		
		if (result == Result.AIWIN) {
			roundsSoFar++;
			aiWins[aiMove.ordinal()]+=1;
			playerLosses[playerMove.ordinal()]+=1;
			aiScore+=1;
			
		} else if (result == Result.HUMANWIN){
			roundsSoFar++;
			playerWins[playerMove.ordinal()]+=1;
			aiLosses[aiMove.ordinal()]+=1;
			playerScore+=1;
			
		} else {
			playerTies[playerMove.ordinal()]+=1;
			aiTies[aiMove.ordinal()]+=1;
		}
		
	}

	/**
	 * Checks to see if the game has started yet
	 * @return true if has not.
	 */
	public boolean isNotEmpty() {
		if(roundsSoFar == 0 && numTies == 0)
			return false;
		else
			return true;
	}
	/**
	 * Visual representation of the board
	 * @return string that holds all data in board.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AI Score: "+aiScore+"/"+roundsSoFar+"\n");
		builder.append("Player Score: "+playerScore+"/"+roundsSoFar+"\n");
		Move[] moves = rules.getMoves();
		for (int i=0;i<moves.length;i++) {
			int actionWins = playerWins[moves[i].ordinal()];
			int actionLosses = playerLosses[moves[i].ordinal()];
			int actionTies = playerTies[moves[i].ordinal()];
			builder.append("Player using ");
			builder.append(moves[i].label+" W/L/T: "+actionWins+"/"+actionLosses+"/"+actionTies+"\n");
			
		}
		for (int i=0;i<moves.length;i++) {
			int actionWins = aiWins[moves[i].ordinal()];
			int actionLosses = aiLosses[moves[i].ordinal()];
			int actionTies = aiTies[moves[i].ordinal()];
			builder.append("AI using ");
			builder.append(moves[i].label+" W/L/T: "+actionWins+"/"+actionLosses+"/"+actionTies+"\n");
		}
		return builder.toString();
	}
	
	private Rules rules;
	private int aiScore;
	private int playerScore;
	private int roundsSoFar;
	private int numTies;
	private int[] playerWins;
	private int[] playerLosses;
	private int[] playerTies;
	private int[] aiWins;
	private int[] aiLosses;
	private int[] aiTies;

}
