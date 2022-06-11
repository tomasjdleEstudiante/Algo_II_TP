package competitor.exceptions;

public class CompetitorInLeagueException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1677178517092058847L;

	/**
	 * This exception is meant to be used when a trying to add a competitor to a league when said competitor is already on another league
	 * */
	public CompetitorInLeagueException(String message) {
		super(message);
	}
}
