package rpsls;

import java.util.Scanner;

public class StdTalker extends Talker{
	private Scanner inputScanner;
	/**
	 * Constructor connects an instance of the java scanner class to the Talker object.
	 * @param scanner
	 */
	public StdTalker(Scanner scanner) {
		this.inputScanner = scanner;
	}
	/**
	 * Welcome banner.
	 */
	@Override
	public void welcomeToGame() {
		System.out.println("Welcome to a Rock-Paper-Scissors console game!\n");
	}
	/**
	 * Rules and regulations message.
	 */
	@Override
	public void teach() {
		System.out.println("Rules:");
		System.out.println("	1. Rock crushes scissors");
		System.out.println("	2. Paper smothers rock");
		System.out.println("	3. Scissors cut paper\n");
		System.out.println("Instructions:");
		System.out.println("When prompted input the following commands for your move");
		System.out.println("	r+ENTER: Rock");
		System.out.println("	p+ENTER: Paper");
		System.out.println("	s+ENTER: Scissors\n");
		
	}
	/**
	 * Safely asks for a user's input before going on.
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
	 * Welcome message.
	 */
	@Override
	public void welcomeToRound(int roundNumber) {
		System.out.println("Round "+roundNumber+":");
	}
	/**
	 * Safely gets user input for their move.
	 * @return a move instance.
	 */
	@Override
	public Move askForMove() {
		System.out.print("Your move? (r/p/s+ENTER): ");
		
		while(true) {
			String nextLine = inputScanner.next();
			
			if(nextLine.length()==1 && nextLine.charAt(0)=='r') {
				return Move.ROCK;
				
			} else if (nextLine.length()==1 && nextLine.charAt(0)=='p') {
				return Move.PAPER;
				
			} else if (nextLine.length()==1 && nextLine.charAt(0)=='s') {
				return Move.SCISSORS;
				
			} else {
				System.out.println("Please provide a valid input!\n");
				System.out.print("Your move? (r/p/s+ENTER): ");
			}
		}
	}
	/**
	 * Reveal round winner.
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
