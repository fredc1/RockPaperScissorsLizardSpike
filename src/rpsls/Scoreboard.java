package rpsls;

public class Scoreboard {
	private Rules rules;
	private int aiScore;
	private int playerScore;
	private int roundsSoFar;
	private int numTies;
	private int[] playerWins;
	private int[] playerLosses;
	private int[] playerTies;
	private int[] aiWins;
	private int[] aiLosses;
	private int[] aiTies;

	public Scoreboard(Rules rules) {
		this.rules = rules;
		aiScore = 0;
		playerScore = 0;
		roundsSoFar = 0;
		int dim = rules.getMoves().length;
		playerWins = new int[dim];
		playerLosses = new int[dim];
		playerTies = new int[dim];
		aiWins = new int[dim];
		aiLosses = new int[dim];
		aiTies = new int[dim];
	}
	public void update(Move playerMove, Move aiMove, Result result) {
		
		if (result == Result.AIWIN) {
			roundsSoFar++;
			aiWins[aiMove.ordinal()]+=1;
			playerLosses[playerMove.ordinal()]+=1;
			aiScore+=1;
			
		} else if (result == Result.HUMANWIN){
			roundsSoFar++;
			playerWins[playerMove.ordinal()]+=1;
			aiLosses[aiMove.ordinal()]+=1;
			playerScore+=1;
			
		} else {
			playerTies[playerMove.ordinal()]+=1;
			aiTies[aiMove.ordinal()]+=1;
		}
		
	}


	public boolean isNotEmpty() {
		if(roundsSoFar == 0 && numTies == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AI Score: "+aiScore+"/"+roundsSoFar+"\n");
		builder.append("Player Score: "+playerScore+"/"+roundsSoFar+"\n");
		Move[] moves = rules.getMoves();
		for (int i=0;i<moves.length;i++) {
			int actionWins = playerWins[moves[i].ordinal()];
			int actionLosses = playerLosses[moves[i].ordinal()];
			int actionTies = playerTies[moves[i].ordinal()];
			builder.append("Player using ");
			builder.append(moves[i].label+" W/L/T: "+actionWins+"/"+actionLosses+"/"+actionTies+"\n");
			
		}
		for (int i=0;i<moves.length;i++) {
			int actionWins = aiWins[moves[i].ordinal()];
			int actionLosses = aiLosses[moves[i].ordinal()];
			int actionTies = aiTies[moves[i].ordinal()];
			builder.append("AI using ");
			builder.append(moves[i].label+" W/L/T: "+actionWins+"/"+actionLosses+"/"+actionTies+"\n");
		}
		return builder.toString();
	}

}
