package rpsls;

public class Scoreboard {
	private Rules rules;
	private int aiScore;
	private int playerScore;
	private int roundsSoFar;
	private int[] playerWins;
	private int[] playerLosses;
	private int[] aiWins;
	private int[] aiLosses;

	public Scoreboard(Rules rules) {
		this.rules = rules;
		aiScore = 0;
		playerScore = 0;
		roundsSoFar = 0;
		int dim = rules.getActions().length;
		playerWins = new int[dim];
		playerLosses = new int[dim];
		aiWins = new int[dim];
		aiLosses = new int[dim];
	}
	public void update(Move playerMove, Move aiMove, Result result) {
		roundsSoFar++;
		if (result == Result.AIWIN) {
			
			aiWins[aiMove.ordinal()]+=1;
			playerLosses[playerMove.ordinal()]+=1;
			aiScore+=1;
			
		} else if (result == Result.HUMANWIN){
			
			playerWins[playerMove.ordinal()]+=1;
			aiLosses[aiMove.ordinal()]+=1;
			playerScore+=1;
			
		}
		
	}


	public boolean isNotEmpty() {
		if(roundsSoFar == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AI Score     : "+aiScore+"/"+roundsSoFar+"\n");
		builder.append("Player Score : "+playerScore+"/"+roundsSoFar+"\n");
		Action[] actions = rules.getActions();
		for (int i=0;i<actions.length;i++) {
			int actionWins = playerWins[actions[i].ordinal()];
			int actionLosses = playerLosses[actions[i].ordinal()];
			builder.append("Player using "+actions[i].label+" W/L: "+actionWins+"/"+actionLosses);
		}
		for (int i=0;i<actions.length;i++) {
			int actionWins = aiWins[actions[i].ordinal()];
			int actionLosses = aiLosses[actions[i].ordinal()];
			builder.append("AI using "+actions[i].label+" W/L: "+actionWins+"/"+actionLosses);
		}
		return builder.toString();
	}

}
