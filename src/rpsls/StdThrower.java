package rpsls;

public class StdThrower extends Thrower{
	/**
	 * Default empty constructor should probably find a better way to do this.
	 */
	public StdThrower() {}
	/**
	 * Uses engine to get the move of the AI
	 * @return a move.
	 */
	@Override
	public Move getMove(History history) {
		Move[] moves = {Move.ROCK,Move.PAPER,Move.SCISSORS};
		int randIndex = (int)(2.99999*Math.random());
		return moves[randIndex];
	}

}
