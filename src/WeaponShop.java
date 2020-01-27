
import java.util.*;
import java.io.*;

/**
 *the weapon shop, constructs weapon shop which stores all the equipments, allows user to sort and search
 * @author RAY
 */
public class WeaponShop {

    private ArrayList<ArrayList<Equipment>> weaponList;
    private ArrayList<Equipment> gunsList;
    private ArrayList<Equipment> meleeWeaponsList;
    private ArrayList<Equipment> grenadesList;
    private ArrayList<Equipment> helmetsList;
    private ArrayList<Equipment> vestsList;
    private ArrayList<Equipment> bulletsList;

    /**
     * constructs weapon shop, which contains equipments
     */
    public WeaponShop() {
        // create new Array list, like shelfs with differnt categories of items
        gunsList = new ArrayList<>();
        meleeWeaponsList = new ArrayList<>();
        grenadesList = new ArrayList<>();
        helmetsList = new ArrayList<>();
        vestsList = new ArrayList<>();
        bulletsList = new ArrayList<>();
        weaponList = new ArrayList<>();

        // add all Arraylists to a big array list, add the shelfs into the shop
        weaponList.add(gunsList);
        weaponList.add(meleeWeaponsList);
        weaponList.add(grenadesList);
        weaponList.add(helmetsList);
        weaponList.add(vestsList);
        weaponList.add(bulletsList);//this allows the shop to have more shelfs if needed
    }

    /**
     * searches an equipment in the shop
     * @param name name of the item being searched
     * @return the item searched or null if not have this equipment
     */
    public Equipment searchEquipmentByName(String name) {
        for (ArrayList<Equipment> a : weaponList) {
            for (Equipment e : a) {
                if (e.getName().equalsIgnoreCase(name)) {
                    return e;
                }
            }
        }  
        return null;
    }

    /**
     * searches an equipment on a shelf
     * @param name name of the item
     * @param index index of the shelf, indicating which category to search
     * @return item searched
     */
    public Equipment searchOneTypeByName(String name, int index) {
        for (Equipment e : weaponList.get(index)) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }

        
        return null;
    }

    /**
     * loads the file, puts all the equipments into the shop
     */
    public void loadEquipments() {
        File f = new File("src/storage.txt");
        String information;
        String[] info;

        try {
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                information = in.nextLine();
                info = information.split(",");

                //in the file, the first word is identifer, if more types of equipment are created, simply use other identifer
                if (info[0].equals("Gun")) {
                    weaponList.get(0).add(new Gun(info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]), Double.parseDouble(info[9])));
                } else if (info[0].equals("MeleeWeapon")) {
                    weaponList.get(1).add(new MeleeWeapon(info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), Double.parseDouble(info[5])));
                } else if (info[0].equals("Grenade")) {
                    weaponList.get(2).add(new Grenade(info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), Integer.parseInt(info[5]), Double.parseDouble(info[6])));
                } else if (info[0].equals("Helmet")) {
                    weaponList.get(3).add(new Helmet(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4])));
                } else if (info[0].equals("Vest")) {
                    weaponList.get(4).add(new Vest(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4])));
                } else if (info[0].equals("Bullet")) {
                    weaponList.get(5).add(new Bullet(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3])));
                }

            }
            in.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * shows the equipments on a shelf
     * @param index index of the shelf
     */
    public void showList(int index) {
        for (Equipment e : weaponList.get(index)) {
            e.showInfo();
            System.out.println("");
        }
    }
    
    /**
     * sorts a shelf by name
     * @param index index of the shelf
     */
    public void sortByName(int index){
        String[] names = new String[weaponList.get(index).size()];
        for(int i = 0; i < weaponList.get(index).size(); i ++){
            names[i] = weaponList.get(index).get(i).getName();
        }
        sortName(names, weaponList.get(index));
        
    }
    
    /**
     * sorts a shelf by ammo type (only available when the shelf contains gun)
     * @param index index of the shelf
     */
    public void sortByAmmoType(int index){
        String[] ammoTypes = new String[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            ammoTypes[i] = ((Gun)weaponList.get(index).get(i)).getAmmoType();
        }
        sortName(ammoTypes, weaponList.get(index));
    }

    /**
     * sorts a shelf, cheaper ones come first
     * @param index index of the shelf
     */
    public void cheapFirst(int index) {
        double[] prices = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            prices[i] = weaponList.get(index).get(i).getPrice();
        }
        WeaponShop.sortLowFirst(prices, weaponList.get(index));
        
    }

    /**
     * sorts a shelf, more expensive ones come first
     * @param index index of the shelf
     */
    public void expensiveFirst(int index) {
        cheapFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
       
    }

    /**
     * sorts a shelf, lower DPS ones come first (only available when the shelf contains weapons)
     * @param index index of the shelf
     */
    public void lowDpsFirst(int index) {
        double[] dps = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            dps[i] = ((Weapon) weaponList.get(index).get(i)).calDps();
        }
        WeaponShop.sortLowFirst(dps, weaponList.get(index));
        
    }

    /**
     * sorts a shelf, higher DPS ones come first (only available when the shelf contains weapons)
     * @param index index of the shelf
     */
    public void highDpsFirst(int index) {
        lowDpsFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1 );
        }
        
    }
    
    /**
     * sorts a shelf, less shield ones come first(only available when shelf contains protective gears)
     * @param index index of the shelf
     */
    public void lowShieldFirst(int index){
        double[] shields = new double[weaponList.get(index).size()];
        for(int i = 0; i < weaponList.get(index).size(); i++){
            shields[i] = ((ProtectiveGear)weaponList.get(index).get(i)).getShield();
        }
        WeaponShop.sortLowFirst(shields, weaponList.get(index));
        
    }
    
    /**
     * sorts a shelf, more shield ones come first (only available when shelf contains protective gears)
     * @param index index of the shelf
     */
    public void highShieldFirst(int index){
        lowShieldFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
    }
    
    /**
     * sorts a shelf, lower level ones come first (only available when shelf contains protective gears) 
     * @param index index of the shelf
     */
    public void lowLevelFirst(int index){
        double[] levels = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            levels[i] = ((ProtectiveGear)weaponList.get(index).get(i)).getLevel();
        }
        WeaponShop.sortLowFirst(levels, weaponList.get(index));
    }
    
    /**
     * sorts a shelf, higher level ones come first (only available when shelf contains protective gears) 
     * @param index index of the shelf
     */
    public void highLevelFirst(int index){
        lowLevelFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
    }
    
    /**
     * sorts a shelf, shorter delay ones come first (only available when shelf contains grenades) 
     * @param index index of the shelf
     */
    public void lowDelayFirst (int index){
        double[] delays = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            delays[i] = ((Grenade)weaponList.get(index).get(i)).getDelay();
        }
        WeaponShop.sortLowFirst(delays, weaponList.get(index));
    }
    
    /**
     * sorts a shelf, longer delay ones come first (only available when shelf contains grenades) 
     * @param index index of the shelf
     */
    public void highDelayFirst(int index){
        lowDelayFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
    }
    
    /**
     * sorts a shelf, shorter reload time ones come first (only available when shelf contains guns) 
     * @param index index of the shelf
     */
    public void lowReloadTimeFirst(int index){
        double[] reloadTimes = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            reloadTimes[i] = ((Gun)weaponList.get(index).get(i)).getReloadTime();
        }
        WeaponShop.sortLowFirst(reloadTimes, weaponList.get(index));
    }
    
    /**
     * sorts a shelf, longer reload time ones come first (only available when shelf contains guns) 
     * @param index index of the shelf
     */
    public void highReloadTimeFirst(int index){
        lowReloadTimeFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
    }
        
    /**
     * sorts a shelf, shorter range ones come first (only available when shelf contains weapons) 
     * @param index index of the shelf
     */
    public void shortRangeFirst(int index){
        double[] ranges = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            ranges[i] = ((Weapon)weaponList.get(index).get(i)).getRange();
        }
        WeaponShop.sortLowFirst(ranges, weaponList.get(index));
    }
    
    /**
     * sorts a shelf, longer range ones come first (only available when shelf contains weapons) 
     * @param index index of the shelf
     */
    public void longRangeFirst(int index){
        shortRangeFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
    }
    
    /**
     * sorts a shelf, lower attack speed ones come first (only available when shelf contains weapons) 
     * @param index index of the shelf
     */
    public void lowAttackSpeedFirst(int index){
        double[] attackSpeeds = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            attackSpeeds[i] = ((Weapon)weaponList.get(index).get(i)).getAttackSpeed();
        }
        WeaponShop.sortLowFirst(attackSpeeds, weaponList.get(index));
    }
    
    /**
     * sorts a shelf, higher attack speed ones come first (only available when shelf contains weapons) 
     * @param index index of the shelf
     */
    public void highAttackSpeedFirst(int index){
        lowAttackSpeedFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
    }
    
    /**
     * sorts a shelf, low damage per attack ones come first (only available when shelf contains weapons) 
     * @param index index of the shelf
     */
    public void lowDamagePerAttackFirst(int index){
        double[] damages = new double[weaponList.get(index).size()];
        for (int i = 0; i < weaponList.get(index).size(); i++) {
            damages[i] = ((Weapon)weaponList.get(index).get(i)).getDamagePerAttack();
        }
        WeaponShop.sortLowFirst(damages, weaponList.get(index));
    }
    
    /**
     * sorts a shelf, higher damage per attack ones come first (only available when shelf contains weapons) 
     * @param index index of the shelf
     */
    public void highDamagePerAttackFirst(int index){
        lowDamagePerAttackFirst(index);
        for (int i = 0; i <= (weaponList.get(index).size() - 1) / 2; i++) {
            swapEquipment(weaponList.get(index), i, weaponList.get(index).size() - i - 1);
        }
    }

    /**
     * sorts the lower ones first. 
     * @param value the value correspond to the objects
     * @param weapons the objects being sorted
     */
    private static void sortLowFirst(double[] value, ArrayList<Equipment> weapons) {
        for (int i = 0; i < value.length; i++) {
            if (i == 0) {
                continue;//?
            }
            int pos = i;
            while (pos >= 1 && value[pos] < value[pos - 1]) {
                swapValue(value, pos, pos - 1);
                swapEquipment(weapons, pos, pos - 1);
                pos--;
            }
        }
    }

    /**
     * sorts objects according to names 
     * @param names the names correspond to the objects
     * @param weapons the objects being sorted
     */
    private static void sortName(String[] names, ArrayList<Equipment> weapons) {
        for (int i = 0; i < names.length; i++) {
            if (i == 0) {
                continue;//?
            }
            int pos = i;
            while (pos >= 1 && (names[pos].compareTo(names[pos - 1])) < 0) {
                swapName(names, pos, pos - 1);
                swapEquipment(weapons, pos, pos - 1);
                pos--;
            }
        }
    }

    /**
     * swaps the objects in an array according to indexes 
     * @param arr array that contains names
     * @param index1 index 1
     * @param index2 index 2
     */
    private static void swapName(String[] arr, int index1, int index2) {
        String name = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = name;
    }

    /**
     * swaps the value in an array according to indexes
     * @param arr array that contains certain values
     * @param index1 index 1
     * @param index2 index 2
     */
    private static void swapValue(double[] arr, int index1, int index2) {
        double value = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = value;
    }

    /**
     * swaps the equipment on an shelf according to indexes
     * @param weapons the shelf
     * @param index1 index 1
     * @param index2 index 2
     */
    private static void swapEquipment(ArrayList<Equipment> weapons, int index1, int index2) {
        Equipment e = weapons.get(index1);
        weapons.set(index1, weapons.get(index2));
        weapons.set(index2, e);

    }

}