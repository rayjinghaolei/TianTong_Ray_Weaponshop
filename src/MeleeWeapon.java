
public class MeleeWeapon extends Weapon {
    
    /**
     * constructs melee weapons
     * @param name name of the melee weapon
     * @param price price of the melee weapon
     * @param attackSpeed the attack speed of the melee weapon
     * @param range range of the weapon
     * @param damagePerAttack the damage it causes per attack
     */
    public MeleeWeapon(String name, int price, double attackSpeed, int range, double damagePerAttack) {
        super(name, price, attackSpeed, range, damagePerAttack);

    }
    
    /**
     * shows the info of melee weapon
     */
    public void showInfo() {
        super.showInfo();

    }
    
    /**
     * converts the object into csv format
     * @return melee weapon in csv format
     */
    public String toString() {
        return super.toString();
    }

    /**
     * calculates the dps
     * @return dps
     */
    public double calDps() {
        return getAttackSpeed() * getDamagePerAttack();
    }
}
