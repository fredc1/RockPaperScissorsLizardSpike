package rpsls;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Abstract Object Model of Game Logic.
 * This allows the raw action result tables to provide all the game logic 
 * to the classes that need to reference it. It serves mostly to encapsulate
 * the "type" of game into one variable.
 * @author frederickcunningham
 *
 */
public class Rules {
	/**
	 * Constructor. Takes info from main and packages into object that
	 * fully determines the game.
	 * @param actionTable represents a grid where [winner][looser] specifies the
	 * action the winner inflicts upon the looser.
	 * @param resultTable represents a grid where [player1][player2] specifies
	 * a result enumeration corresponding to AI vs Human victory.
	 */
	public Rules(Action[][] actionTable, Result[][] resultTable) {
		this.actionTable = actionTable;
		this.resultTable = resultTable;
		this.dim = resultTable.length;
		this.potentialMoves = Arrays.copyOfRange(Move.values(), 0, dim);
	}
	/**
	 * 
	 * @return action words table from rules.
	 */
	public Action[][] getActionRules() {
		return actionTable;
	}
	/**
	 * 
	 * @return results enumerations table from rules.
	 */
	public Result[][] getResultRules() {
		return resultTable;
	}
	/**
	 * 
	 * @return a list of actions that the user or AI can legally execute.
	 */
	public Move[] getMoves() {
		return potentialMoves;
	}
	/**
	 * This function takes in a move and returns a move that will beat the input move
	 * using the rules of the game. If there are multiple rules that will win,
	 * it chooses one randomly.
	 * @param move is the input move to beat.
	 * @return the move that beats the input move.
	 */
	public Move getRandomCounterMove(Move move) {
		
		ArrayList<Move> counterMoves= new ArrayList<Move>();
		Move[] moves = getMoves();
		for (int i = 0;i<dim;i++) {
			Result result = resultTable[move.ordinal()][i];
			//searching for moves that the AI can use to beat a player move
			if (result == Result.AIWIN) { 
				counterMoves.add(moves[i]);
			}
		}
		int rnd = (int)((counterMoves.size()-0.000001)*Math.random());
		return counterMoves.get(rnd);
	}
	
	private Action[][] actionTable;
	private Result[][] resultTable;
	private Move[] potentialMoves;
	private int dim;
}
