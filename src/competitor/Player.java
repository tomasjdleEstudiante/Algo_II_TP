package competitor;

import java.util.HashMap;
import java.util.Map;

public class Player extends Competitor{

    @SuppressWarnings("unused")
	private String realName;
    private Map<Trait,Integer> traits = new HashMap<Trait,Integer>();

    /**
     * Constructs a Player that is not initially on a league with the given attributes 
     * @param alignment what the player is (a Hero or a Villain)
     * @param realName the real identity of the player
     * @param fictionalName the alter ego of the player
     * @param speed the value of this trait
     * @param strength the value of this trait
     * @param stamina the value of this trait
     * @param dexterity the value of this trait
     */
    public Player(Alignment alignment, String realName, String fictionalName, int speed, int strength, int stamina, int dexterity){
        super();
    	
    	this.alignment = alignment;
        this.name = fictionalName;
        this.realName = realName;
        this.traits.put(Trait.SPEED,speed);
        this.traits.put(Trait.STRENGTH,strength);
        this.traits.put(Trait.STAMINA,stamina);
        this.traits.put(Trait.DEXTERITY,dexterity);
    }
    
    @Override
    public int getTrait(Trait trait) {
		return traits.get(trait);	
    }

}
