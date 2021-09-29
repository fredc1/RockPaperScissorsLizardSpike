package rpsls;

public class Runner {
	
	/**
	 * The following is the rough control logic of the RPSLS game.
	 * 	0. Define rules/type of game
	 * 	1. Give the user a welcome message and instructions
	 * 	2. Start a game w/ 100 rounds
	 * 	3. Query AI
	 * 	4. Query User
	 * 	5. Display round result
	 * 	6. GoTo 3. unless round number = 101;
	 * 	7. Display game results
	 * 	8. End game
	 * 
	 * Part 1 Comments and Question Answers
	 * 	The main idea for my design of this program was to write out the main
	 * steps required for a human to "run the game" and then to figure out how
	 * that control flow separated into different types of work. Of course the
	 * most crucial element was finding a way to represent the game that was 
	 * extensible to expansion, but also compact and global to the entire program.
	 * For some reason, I made this harder on myself by also adding in the original
	 * words from the big bang theory TV show associated with one type of move
	 * beating the other. It would be ironic if I didn't finish the part that 
	 * actually uses the fancy words.
	 * 
	 * 	1. The instructions were clear, but they could have more aesthetically
	 * pleasing.
	 * 	2. The required interaction at each round proceeded smoothly asside from a
	 * bug that had to be corrected. It could have been improved by keeping a
	 * running tally of the score as the rounds progressed.
	 * 	3. The user did not like the zero indexing of the rounds. They were annoyed
	 * by the frequency of ties.
	 * 	4. The user requested for running statistics on the AI and human guesses
	 * which is reasonable, but would require a lot of new code.
	 * 	5. A
	 * 
	 * Part 2 Comments and Question Answers
	 * 
	 */
	public static void main(String[] args) {
		
		int numRounds = 20;
		//[winner move][looser move]
		Action[][] stdActionTable = {
					{ Action.TIES  , null       , Action.CRUSHES },
					{ Action.COVERS, Action.TIES, null           },
					{ null         , Action.CUTS, Action.TIES    }};
		
		//[player move][AI move]
		Result[][] stdResultTable = {
					{ Result.TIE     , Result.AIWIN   , Result.HUMANWIN },
					{ Result.HUMANWIN, Result.TIE     , Result.AIWIN    },
					{ Result.AIWIN   , Result.HUMANWIN, Result.TIE      }};
		Rules stdRules = new Rules(stdActionTable,stdResultTable);
		
		Game rpsGame = Game.newGame(numRounds,stdRules);
		
		rpsGame.welcomePlayer();
		
		try {
			rpsGame.play();
		} catch (Exception e) {//enforces order in which you call game methods
			e.printStackTrace();
		}
		rpsGame.summarize();
		rpsGame.close();

	}

}
