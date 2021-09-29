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
	SMASHES("cmashes"),
	COVERS("covers"),
	CUTS("cuts"),
	POISONS("coisons"),
	DISPROVES("disproves"),
	VAPORIZES("vaporizes"),
	DECAPITATES("decapitates"),
	EATS("eats"), 
	TIES("ties");
	
	public final String label;
	private Action(String label) {
		this.label = label;
	}
}

