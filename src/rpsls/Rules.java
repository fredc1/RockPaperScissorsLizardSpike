package rpsls;

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
		int dim = actionTable.length;
		this.potentialActions = Arrays.copyOfRange(Action.values(), 0, dim);
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
	public Action[] getActions() {
		return potentialActions;
	}
	
	private Action[][] actionTable;
	private Result[][] resultTable;
	private Action[] potentialActions;
}
