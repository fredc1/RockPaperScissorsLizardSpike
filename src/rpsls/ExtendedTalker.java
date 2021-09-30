package rpsls;

import java.util.Scanner;
/**
 * This talker class was added specifically to handle RPSLS extension to RPS
 * It handles all System.out.println() calls for the RPSLS UI
 * @author frederickcunningham
 *
 */
public class ExtendedTalker extends Talker{
	private Scanner inputScanner;
	
	/**
	 * Constructor connects a java Scanner object to an instance.
	 * @param scanner
	 */
	public ExtendedTalker(Scanner scanner) {
		this.inputScanner = scanner;
	}
	/**
	 * Welcome message.
	 */
	@Override
	public void welcomeToGame() {
		System.out.println("Welcome to a Rock-Paper-Scissors-Lizard-Spock console game!\n");
	}
	/**
	 * Rules and regulations message.
	 */
	@Override
	public void teach() {
		System.out.println("Rules:");
		System.out.println("	 1. Rock crushes scissors");
		System.out.println("	 2. Paper covers rock");
		System.out.println("	 3. Scissors cut paper");
		System.out.println("	 4. Rock crushes lizard");
		System.out.println("	 5. Lizard poisons spock");
		System.out.println("	 6. Spock smashes scissors");
		System.out.println("	 7. Scissors decapitates lizard");
		System.out.println("	 8. Lizard eats paper");
		System.out.println("	 9. Paper disprooves spock");
		System.out.println("	10. Spock vaporizes rock\n");
		System.out.println("Instructions:");
		System.out.println("When prompted input the following commands for your move");
		System.out.println("	r+ENTER: Rock");
		System.out.println("	p+ENTER: Paper");
		System.out.println("	s+ENTER: Scissors");
		System.out.println("	l+ENTER: Lizard");
		System.out.println("	S+ENTER: Spock\n");
		
	}
	/**
	 * Safely asks for user's permission to proceed.
	 */
	@Override
	public void askToProceed() {
		System.out.print("Start the game? (y/n+ENTER): ");
		boolean seekingValidInput = true;
		while(seekingValidInput) {
			String nextLine = inputScanner.next();
			if(nextLine.length()==1 && nextLine.charAt(0)=='y') {
				System.out.println("\n\n\n\n\n");
				seekingValidInput = false;
			} else if (nextLine.length()==1 && nextLine.charAt(0)=='n') {
				System.exit(0);
			} else {
				System.out.println("Please provide a valid input!\n");
				System.out.print("Start the game? (y/n+ENTER): ");
			}
		}
		
	}
	/**
	 * Welcome to round message.
	 */
	@Override
	public void welcomeToRound(int roundNumber) {
		System.out.println("Round "+roundNumber+":");
	}
	/**
	 * Safely gets user input for their move.
	 * @return a Move instance.
	 */
	@Override
	public Move askForMove() {
		System.out.print("Your move? (r/p/s/l/S+ENTER): ");
		
		while(true) {
			String nextLine = inputScanner.next();
			
			if(nextLine.length()==1 && nextLine.charAt(0)=='r') {
				return Move.ROCK;
				
			} else if (nextLine.length()==1 && nextLine.charAt(0)=='p') {
				return Move.PAPER;
				
			} else if (nextLine.length()==1 && nextLine.charAt(0)=='s') {
				return Move.SCISSORS;
				
			} else if (nextLine.length()==1 && nextLine.charAt(0)=='l') {
				return Move.LIZARD;
				
			} else if (nextLine.length()==1 && nextLine.charAt(0)=='S') {
				return Move.SPOCK;
				
			} else {
				System.out.println("Please provide a valid input!\n");
				System.out.print("Your move? (r/p/s/l/S+ENTER): ");
			}
		}
	}
	/**
	 * Show round winner.
	 */
	@Override
	public void revealRoundOutcome(Move aiMove, String announcement) {
		System.out.print("AI played: "+aiMove.label+", and ");
		System.out.println(announcement+"...");
	}
	/**
	 * Winning message.
	 */
	@Override
	public void congratulate() {
		System.out.println("You win this round!\n");
		
	}
	/**
	 * Losing message.
	 */
	@Override
	public void console() {
		System.out.println("You lost... Maybe you'll win next time!\n");
	}
	/**
	 * Tie message.
	 */
	@Override
	public void announceTie() {
		System.out.println("Tie game. Replay this round\n");
		
	}
	/**
	 * Game over message.
	 */
	@Override
	public void summarizeGame(String string) {
		System.out.println(string);
	}

}
