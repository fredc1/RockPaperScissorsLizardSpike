package rpsls;
/**
 * Enumeration of the Moves available in the game Rock-Paper-Scissors
 * and its expansions. The labels are hard coded from the real world.
 * @author frederickcunningham
 *
 */
public enum Move {
	ROCK("Rock"), 
	PAPER("Paper"), 
	SCISSORS("Scissors"), 
	LIZARD("Lizard"), 
	SPOCK("Spock");
	
	public final String label;
	/**
	 * Enum Constructor used to attach a string to each constant.
	 * @param label
	 */
	private Move(String label) {
		this.label = label;
	}

}
