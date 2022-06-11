package competitor;

import java.util.*;

import competitor.exceptions.*;

public class League extends Competitor {
	
	// TIENE QUE BORRAR PERSONAJE??
	
	private List<Competitor> league = new ArrayList<Competitor>();

	/**
	 * Constructs a League that is not initially on another league and all its traits are 0
	 * @param name the name of the league
	 */
	public League(String name) {
		super();
		
		this.alignment = null;
		this.name = name;
	}

	/**
	 * Adds a competitor if it has the correct alignment and is not already in another league
	 * <br>
	 * If the league does not have an alignment then the first competitor's alignment is the alignment of the league 
	 * @param competitor the competitor you are going to add to the league
	 * 
	 */
	public void addCompetitor(Competitor competitor) {
		
		try {
			
			if(competitor.isOnALeague) {
				throw new CompetitorInLeagueException("A competitor that is already part of a league can't be added to another one");
			}
			
			if(competitor.alignment == null) {
				throw new NoAlignmentException("A competitor with no alignment cannot be added to a league");
			}
			
			if(this.alignment == null) {
				this.alignment = competitor.alignment;
			}else if(competitor.alignment != this.alignment) {
				throw new DifferentAlignmentException("The competitor added must have the same alignment as the rest of the league");
			}
			
			this.league.add(competitor);
			competitor.isOnALeague = true;			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int getTrait(Trait trait) {
		int total = 0;
		
		Iterator<Competitor> itr = this.league.iterator();
		while (itr.hasNext()) {
			total += itr.next().getTrait(trait);
		}
		
		total /= league.size();
		
		return total;
	}
}
