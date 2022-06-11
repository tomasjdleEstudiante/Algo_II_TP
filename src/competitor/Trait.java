package competitor;

public enum Trait{
    SPEED,STRENGTH,STAMINA,DEXTERITY;
	
	private static Trait[] vals = values();
	/**
	 * @return The next Trait in the ordinal order returning the first one if you are in the last one
	 * @Order				1. Speed<br>
	 *                      2. Strength<br>
	 *                      3. Stamina<br>
	 *                      4. Dexterity
	 * */
    public Trait next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
