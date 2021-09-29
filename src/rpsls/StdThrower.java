package rpsls;

public class StdThrower extends Thrower{
	
	public StdThrower() {}
	
	@Override
	public Move getMove() {
		Move[] moves = {Move.ROCK,Move.PAPER,Move.SCISSORS};
		int randIndex = (int)(3*Math.random());
		return moves[randIndex];
	}

}
