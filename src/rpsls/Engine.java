package rpsls;
/**
 * Game Engine Object.
 * 
 * This object handles the logic of the game. It uses the rules and the 
 * state to generate round outcomes.
 * @author frederickcunningham
 *
 */
public class Engine {
	
	/**
	 * Constructor.
	 * 
	 * @param rules (required) specifies what type of Rock Paper Scissors
	 * game you are playing.
	 */
	public Engine(Rules rules) {
		this.rules = rules;
	}
	/**
	 * Compare two moves and output the winner.
	 * @param playerMove is the user's move.
	 * @param aiMove is the computer's move.
	 * @return a Result enumeration mapping to human vs AI success.
	 */
	public Result compareMoves(Move playerMove, Move aiMove) {
		Result[][] resultTable = rules.getResultRules();
		return resultTable[playerMove.ordinal()][aiMove.ordinal()];
	}
	
	/**
	 * Gets a phrase describing the game logic that has been computed.
	 * @param winningMove 
	 * @param loosingMove
	 * @return the announcement as a String.
	 */
	public String getAnnouncement(Move winningMove, Move loosingMove){
		Action[][] actionTable = rules.getActionRules();
		String loosingMoveWord = lowerFirstLetter(loosingMove.label);
		String winningMoveWord = lowerFirstLetter(winningMove.label);
		Action defeatingAction = actionTable[winningMove.ordinal()][loosingMove.ordinal()];
		StringBuilder announcementBuilder = new StringBuilder();
		announcementBuilder.append(winningMoveWord);
		announcementBuilder.append(" ");
		announcementBuilder.append(defeatingAction.label);
		announcementBuilder.append(" ");
		announcementBuilder.append(loosingMoveWord);
		return announcementBuilder.toString();
		
	}
	
	private String lowerFirstLetter(String str) {
		char firstLetter = str.charAt(0);
		char loweredLetter = Character.toLowerCase(firstLetter);
		str = loweredLetter+str.substring(1);
		return str;
	}
	
	private Rules rules;

}
