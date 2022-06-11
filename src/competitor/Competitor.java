package competitor;

import competitor.exceptions.*;

abstract class Competitor{
	
	protected boolean isOnALeague;
	protected Alignment alignment;
	protected String name;
	
	/**
	 * An object that represents a Competitor that has  4 traits (Speed, strength, stamina and dexterity) and is initially not in a league
	 * */
	Competitor(){
		this.isOnALeague = false;
		this.alignment = null;
	}
	
	/**
	 * Compares your trait with an enemie's trait, if your trait is greater you win, 
	 * if your trait is less you lose and if your traits are the same value then the 
	 * method compares the next trait in the default order until you tie 
	 * @Default_trait_Order 1. Speed<br>
	 *                      2. Strength<br>
	 *                      3. Stamina<br>
	 *                      4. Dexterity
	 * @param enemie the competitor you are comparing too
	 * @param trait the initial trait you are using to compare both competitors
	 * @return true if you win the fight and false if you don't or tie
	 * */
	public boolean isWinner(Competitor enemie, Trait trait) throws SameAlignmentException, NoAlignmentException{
		try {
			
			if(enemie.alignment == null) {
				throw new NoAlignmentException("You can't compete with a competitor with no alignment");
			}
			
			if(this.alignment == enemie.alignment) {
				throw new SameAlignmentException("If the competitors have the same alignment thay can't fight");
			}
			
			int traitCap = 0;
			boolean isWinner = false;
			boolean keepGoing = true;
			Trait currentTrait = trait;
			
			while(traitCap <  4 && keepGoing) {
				if(this.getTrait(currentTrait) == enemie.getTrait(currentTrait)) {
					currentTrait = currentTrait.next();
					traitCap ++;
				}else {
					isWinner = this.getTrait(currentTrait) > enemie.getTrait(currentTrait);
					keepGoing = false;
				}	
			}
			
			return isWinner;
		} catch (SameAlignmentException | NoAlignmentException e) {
			throw e;
//			e.printStackTrace();
		}	
		
	}
	
	/**
	 * @param trait the trait you want to get the value from
	 * @return the value of the trait
	 */
	abstract public int getTrait(Trait trait);

}
