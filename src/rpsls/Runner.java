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
	 * 	2. The required interaction at each round proceeded smoothly aside from a
	 * bug that had to be corrected. It could have been improved by keeping a
	 * running taly of the score as the rounds progressed.
	 * 	3. The user did not like the zero indexing of the rounds. They were annoyed
	 * by the frequency of ties.
	 * 	4. The user requested for running statistics on the AI and human guesses
	 * which is reasonable, but would require a lot of new code.
	 * 	5. A
	 * 
	 * Part 2 Comments and Question Answers
	 * 	After playing the enhanced AI (described in the SmartThrower class
	 * that I made I realized that it had its benefits but also its drawbacks. 
	 * It was very good at playing against players who relied heavily on one or two weapons.
	 * However, it could not recognize patterns in players who split their time equally
	 * between the weapons, but had otherwise predictable patters. For example, it was 
	 * essentially random for the player sequence r,p,s,r,p,s,r,p,s,r,p,s,r,p,s... I would be
	 * interested to do more detailed statistics to capture these sorts of trends.
	 * 
	 * 	1. The instructions were clear and good. It could be improved by adding ascii art?
	 * 	2. The interaction was smooth. It could have been improved by a running taly.
	 * 	3. The user did initially try to get the task over with by playing only rock
	 * but were surprised when the computer started playing only paper! 
	 * 	4. The user requested the AI prediction on the players next move which seemed unfair.
	 * 	5. A
	 * 
	 * Part 3 Comments and Question
	 * 	I must admit, I was disappointed at the "smart" strategy to lose 49/51 the user in 
	 * this test. I guess it only works if a user really does have some 
	 * statistically significant bias towards one argument on the order of N=100. 
	 * 
	 * 	6. The user found the random strategy harder even though they actually performed 
	 * better against it. This may be because they interpreted it as less predictable. They
	 * were also sunned by long loosing streaks that occurred by random chance.
	 * 
	 */
	public static void main(String[] args) {
		
		int numRounds = 100;
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
		
		//[winner move][looser move]
		Action[][] exdActionTable = {
				{ Action.TIES  , null       , Action.CRUSHES, Action.CRUSHES    , null             },
				{ Action.COVERS, Action.TIES, null          , null              , Action.DISPROVES },
				{ null         , Action.CUTS, Action.TIES   , Action.DECAPITATES, null },
				{ null         , Action.EATS, null          , Action.TIES       , Action.POISONS },
				{ Action.VAPORIZES, null    , Action.SMASHES, null              , Action.TIES}};
	
		//[player move][AI move]
		Result[][] exdResultTable = {
				{ Result.TIE     , Result.AIWIN   , Result.HUMANWIN , Result.HUMANWIN, Result.AIWIN},
				{ Result.HUMANWIN, Result.TIE     , Result.AIWIN    , Result.AIWIN   , Result.HUMANWIN},
				{ Result.AIWIN   , Result.HUMANWIN, Result.TIE      , Result.HUMANWIN, Result.AIWIN},
				{ Result.AIWIN   , Result.HUMANWIN, Result.AIWIN    , Result.TIE, Result.HUMANWIN},
				{ Result.HUMANWIN, Result.AIWIN   , Result.HUMANWIN , Result.AIWIN, Result.TIE}};
		//Rules stdRules = new Rules(stdActionTable,stdResultTable);
		Rules exdRules = new Rules(exdActionTable,exdResultTable);
		
		Game rpslsGame = Game.newGame(numRounds, exdRules, Strategy.RANDOM);
		rpslsGame.welcomePlayer();
		
		try {
			rpslsGame.play();
		} catch (Exception e) {//enforces order in which you call game methods
			e.printStackTrace();
		}
		rpslsGame.summarize();
		rpslsGame.close();

	}

}
