
/**
 * a class that constructs weapon, extends equipments, will be the super class of other specific weapons
 * 
 */
abstract public class Weapon extends Equipment {

    private double attackSpeed;
    private int range;
    private double damagePerAttack;

    /**
     * constructs a weapon
     * @param name name of the weapon
     * @param price price of the weapon
     * @param attackSpeed the attack speed of the weapon
     * @param range the range of the weapon
     * @param damagePerAttack the damage the weapon can cause per attack
     */
    public Weapon(String name, int price, double attackSpeed, int range, double damagePerAttack) {
        super(name, price);
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.damagePerAttack = damagePerAttack;
    }

    /**
     * shows all info of the weapon
     */
    public void showInfo() {
        super.showInfo();
        System.out.println("Attack Speed: " + attackSpeed + "\nRange: " + range + "\nDamage Per Attack: " + damagePerAttack);
    }

    /**
     * converts the info of weapon into csv format
     * @return info in csv form
     */
    public String toString() {
        return super.toString() + "," + attackSpeed + "," + range + "," + damagePerAttack;
    }

    /**
     * gets attack speed
     * @return attack speed
     */
    public double getAttackSpeed() {
        return attackSpeed;
    }

    /**
     * gets the range 
     * @return range
     */
    public int getRange() {
        return range;
    }
    
    /**
     * gets the damage per attack
     * @return damage per attack
     */
    public double getDamagePerAttack() {
        return damagePerAttack;
    }
    
    /**
     * calculates dps
     * @return dps
     */
    abstract double calDps();

}
