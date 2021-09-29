package rpsls;

/**
 * This history object stores information about the player's history in a game by keeping
 * track of some key statistics like move percentages. This information can be used by
 * a thrower to concoct a better strategy for playing. Note that this version of player
 * history uses O(1) memory and O(1) compute to store information about N things, where 
 * N is the number of moves a player has made previous to any given moment.
 * @author frederickcunningham
 *
 */
public class History {
	
	/**
	 * Constructor
	 * Sets initial statistics to 1/(number of potential moves)
	 * @param rules define the potential moves and their relationships
	 */
	public History(Rules rules) {
		Move[] moves = rules.getMoves();
		int dim = moves.length;
		this.moveStats = new double[dim];
		this.moveTotals = new int[dim];
		this.moveAttempts = dim;
		for(int i = 0; i<dim;i++) {
			moveTotals[i]= 1;
			moveStats[i] = 1.0/dim;
		}
		
	}
	/**
	 * Update the history based on most recent data.
	 * @param move is the move a player just made.
	 */
	public void updateStats(Move move) {
		moveAttempts++;
		moveTotals[move.ordinal()]++;
		for (int i = 0;i<moveStats.length;i++) {
			moveStats[i] = ((double)moveTotals[i])/((double)moveAttempts);
		}
	}
	/**
	 * Get the probability the player will play a certain move.
	 * @param move in question.
	 * @return the probability.
	 */
	public double getMoveStat(Move move) {
		return moveStats[move.ordinal()];
	}
	
	private int[] moveTotals;
	private double[] moveStats;
	private int moveAttempts;
}
