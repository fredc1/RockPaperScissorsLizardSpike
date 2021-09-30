package rpsls;
/**
 * Action enumeration.
 * Records the vocabulary used by sheldon in the 
 * big bang theory tv episode that discusses rock,paper,scissors,lizard, spock.
 * @author frederickcunningham
 *
 */
public enum Action {
	CRUSHES("crushes"),
	SMASHES("smashes"),
	COVERS("covers"),
	CUTS("cuts"),
	POISONS("poisons"),
	DISPROVES("disproves"),
	VAPORIZES("vaporizes"),
	DECAPITATES("decapitates"),
	EATS("eats"), 
	TIES("ties");
	
	
	public final String label;
	
	/**
	 * Enumeration Constructor
	 * I had to use this in order to have a constant be connected to a number and a string.
	 * @param label
	 */
	private Action(String label) {
		this.label = label;
	}
}

