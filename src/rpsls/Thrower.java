package rpsls;
/**
 * Abstract Thrower Provides a functional interface for Game to interface with.
 * @author frederickcunningham
 *
 */
public abstract class Thrower {

	protected abstract Move getMove(History history);
	 

}
