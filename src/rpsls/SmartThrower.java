package rpsls;
/**
 * An AI thrower object that operates on the principle that future beliefs are conditioned
 * by our prior knowledge.
 * 
 * Basically, the AI uses the history of the player to estimate the probability
 * that they will play a certain move. Then they ask the rules for any move that will 
 * counter that move and then play that with the probability just discovered from history.
 * @author frederickcunningham
 *
 */
public class SmartThrower extends Thrower{
	/**
	 * Constructor
	 * Unlike StdThrower, this thrower needs the rules of the game.
	 * @param rules that are passed to the thrower.
	 */
	public SmartThrower(Rules rules){
		this.rules = rules;
	}
	/**
	 * returns the move that is in line with the thrower's strategy
	 * @return the move for the AI to play
	 */
	@Override
	public Move getMove(History playerHistory) {
		Move[] moves = rules.getMoves();
		double[] probabilities = new double[moves.length];
		Move[] counterMoves = new Move[moves.length];
		for (Move move : moves) {
			probabilities[move.ordinal()] = playerHistory.getMoveStat(move);
			counterMoves[move.ordinal()] = rules.getRandomCounterMove(move);
		}
		double sample = Math.random();
		double sum = 0;
		int i = 0;
		for(double p : probabilities) {
			sum+=p;
			if(sample<=sum) {
				return counterMoves[i];
			} else {
				i++;
			}
		}
		return counterMoves[counterMoves.length-1];//for the tiny chance that sample falls between (sum,1)
		
	}
	
	private Rules rules;

}
