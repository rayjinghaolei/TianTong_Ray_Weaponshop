
/**
 * the class constructs protective gear
 */
abstract public class ProtectiveGear extends Equipment {

    private int level;
    private int shield;
    
    /**
     * constructs a protective gear
     * @param name name of the gear
     * @param price price of the gear
     * @param level level of the gear
     * @param shield amount of shield = amount of damage it can block
     */
    public ProtectiveGear(String name, int price, int level, int shield) {
        super(name, price);
        this.level = level;
        this.shield = shield;
    }
    
    /**
     * shows all info of the gear
     */
    public void showInfo() {
        super.showInfo();
        System.out.println("Level: " + level + "\nShield: " + shield);
    }

    /**
     * converts the info of the gear into csv format
     * @return protective gear in csv format
     */
    public String toString() {
        return super.toString() + "," + level + "," + shield;
    }

    /**
     * gets the level of the gear
     * @return level of the gear 
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * gest the shield that the gear has
     * @return amount of shield
     */
    public int getShield() {
        return shield;
    }

}
