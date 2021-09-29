package rpsls;

import java.util.Scanner;

public class StdTalker extends Talker{
	private Scanner inputScanner;
	
	public StdTalker(Scanner scanner) {
		this.inputScanner = scanner;
	}
	@Override
	public void welcomeToGame() {
		System.out.println("Welcome to a Rock-Paper-Scissors console game!\n");
	}

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

	@Override
	public void welcomeToRound(int roundNumber) {
		System.out.println("Round "+roundNumber+":");
	}

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

	@Override
	public void revealRoundOutcome(Move aiMove, String announcement) {
		System.out.print("AI played: "+aiMove.label+", and ");
		System.out.println(announcement+"...");
	}

	@Override
	public void congratulate() {
		System.out.println("You win this round!\n");
		
	}

	@Override
	public void console() {
		System.out.println("You lost... Maybe you'll win next time!\n");
	}

	@Override
	public void announceTie() {
		System.out.println("Tie game. Replay this round\n");
		
	}

	@Override
	public void summarizeGame(String string) {
		System.out.println(string);
	}

}
