package competitor;

import java.util.*;

public class TraitComparator implements Comparator<Competitor> {
	private boolean ascending = true;
	private List<Trait> traitOrder = new ArrayList<Trait>();

	/**
	 * Constructs a comparator with a default trait order<br>
	 * With an ascending order if ascending is true and a descending order if ascending is false
	 * 
	 * @Default_trait_Order 1. Speed<br>
	 *                      2. Strength<br>
	 *                      3. Stamina<br>
	 *                      4. Dexterity
	 */
	public TraitComparator(boolean ascending) {
		this.ascending = ascending;
		// Preguntar a Valeria si se puede hacer esto
		for (Trait trait : Trait.values()) {
			this.traitOrder.add(trait);
		}
	}

	/**
	 * Constructs a comparator with a default trait order and an ascending order
	 * 
	 * @Default_trait_Order 1. Speed<br>
	 *                      2. Strength<br>
	 *                      3. Stamina<br>
	 *                      4. Dexterity
	 * @Default_Order ascending
	 */
	public TraitComparator() {
		// Preguntar a Valeria si se puede hacer esto
		for (Trait trait : Trait.values()) {
			this.traitOrder.add(trait);
		}
	}

	/**
	 * Constructs a comparator with a trait order<br>
	 * With an ascending order if ascending is true and a descending order if ascending is false
	 * 
	 * @param traitOrder a list that contains the traits in the desired order
	 * @param ascending  whether the comparator will give you a ascending or a
	 *                   descending order
	 */
	public TraitComparator(List<Trait> traitOrder, boolean ascending) {
		this.ascending = ascending;
		this.traitOrder = traitOrder;
	}

	/**
	 * Constructs a comparator with a trait order and an ascending order
	 * 
	 * @param traitOrder a list that contains the traits in the desired order
	 */
	public TraitComparator(List<Trait> traitOrder) {
		this.traitOrder = traitOrder;
	}

	@Override
	public int compare(Competitor c1, Competitor c2) {
		int outcome = 0;
		Trait trait = null;

		Iterator<Trait> itr = this.traitOrder.iterator();
		while (itr.hasNext() && outcome == 0) {
			trait = itr.next();
			outcome = Integer.compare(c1.getTrait(trait), c2.getTrait(trait));

		}

		if (!ascending) {
			outcome *= -1;
		}
		
		return outcome;
	}

}
