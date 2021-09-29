package rpsls;

public abstract class Talker {

	protected abstract void welcomeToGame();

	protected abstract void teach();

	protected abstract void askToProceed();

	protected abstract void welcomeToRound(int roundNumber);

	protected abstract Move askForMove();

	protected abstract void revealRoundOutcome(Move aiMove, String announcement);

	protected abstract void congratulate();

	protected abstract void console();

	protected abstract void announceTie();

	protected abstract void summarizeGame(String string);

}
