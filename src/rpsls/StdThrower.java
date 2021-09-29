package rpsls;

public class StdThrower extends Thrower{
	
	public StdThrower() {}
	
	@Override
	public Move getMove(History history) {
		Move[] moves = {Move.ROCK,Move.PAPER,Move.SCISSORS};
		int randIndex = (int)(2.99999*Math.random());
		return moves[randIndex];
	}

}
