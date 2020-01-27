
public class Grenade extends Weapon {

    private int delay;

    /**
     *constructs a grenade
     * @param name the name of the grenade
     * @param price the price of the grenade
     * @param attackSpeed the attack speed, describes how many of this grenade one can throw in one sec
     * @param range the range the grenade covers, the radius of the circle it could damage, in meters
     * @param delay the number of seconds it waits after it hits anything to explode
     * @param damagePerAttack the damage per explode 
     */
    public Grenade(String name, int price, double attackSpeed, int range, int delay, double damagePerAttack) {
        super(name, price, attackSpeed, range, damagePerAttack);
        this.delay = delay;

    }
    
    /**
     * gets delay time
     * @return the time it delays
     */
    public int getDelay() {
        return delay;
    }
    
    /**
     * shows all info of the grenade
     */
    public void showInfo() {
        super.showInfo();
        System.out.println("Delay: " + delay);
    }
    
    /**
     * converts info of grenade into csv format
     * @return grenade in csv
     */
    public String toString() {
        return super.toString() + "," + delay;
    }

    /**
     * calculates the dps of this grenade
     * @return damage per second
     */
    public double calDps() {
        return getAttackSpeed() * getDamagePerAttack() / delay;
    }
}