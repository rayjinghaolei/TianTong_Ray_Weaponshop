
public class Gun extends Weapon {

    private String weaponType;
    private String ammoType;

    private int capacity;
    private double reloadTime;

    /**
     * constructs a gun
     * @param name name of the gun
     * @param price price of the gun
     * @param attackSpeed attack speed of the gun
     * @param range range of the gun
     * @param weaponType they type of the gun, such as sniper or pistol
     * @param ammoType the type of ammo it uses
     * @param damagePerAttack the damage the gun causes per attack
     * @param capacity the capacity of the gun, how much of bullets it contains before reload
     * @param reloadTime the time it takes to reload the gun
     */
    public Gun(String name, int price, double attackSpeed, int range, String weaponType, String ammoType, double damagePerAttack, int capacity, double reloadTime) {
        super(name, price, attackSpeed, range, damagePerAttack);
        this.weaponType = weaponType;
        this.ammoType = ammoType;

        this.capacity = capacity;
        this.reloadTime = reloadTime;
    }

    /**
     * gets the type of weapon
     * @return the weapon type
     */
    public String getWeaponType() {
        return weaponType;
    }

    /**
     * gets the ammo type
     * @return ammo type
     */
    public String getAmmoType() {
        return ammoType;
    }

    /**
     * gets the capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * gets the reload time
     * @return reload time
     */
    public double getReloadTime() {
        return reloadTime;
    }

    /**
     * calculates dps
     * @return 
     */
    public double calDps() {
        return getDamagePerAttack() * getAttackSpeed();
    }

    /**
     * shows all info of the gun
     */
    public void showInfo() {
        super.showInfo();
        System.out.println("Weapon Type: " + weaponType + "\nAmmo Type: " + ammoType + "\nCapacity: " + capacity + "\nReload Time: " + reloadTime);
    }

    /**
     * converts the info into csv format
     * @return info in csv format
     */
    public String toString() {
        return super.toString() + "," + weaponType + "," + ammoType + "," + capacity + "," + reloadTime;
    }

}
