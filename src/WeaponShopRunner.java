import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WeaponShopRunner {

    /**
     * to validate the input for main menu
     *reads a integer with min of 0 and max of input
     * @param in Scanner 
     * @param menuItems the number of items in the menu (max of integer)
     * @return the integer read
     */
    public static int menuInput(Scanner in, int menuItems) {
        try {
            int option = Integer.parseInt(in.nextLine());
            if (option > menuItems || option < 0) {
                System.out.println("\nInvalid option number, Enter again");
                return menuInput(in, menuItems);
            } else {
                return option;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("\nNot a number, input again");
            return menuInput(in, menuItems);
        }
    }

    /**
     * allows a player to buy an item with deduction of money and update in equipment
     * @param p the player
     * @param e the equipment being bought
     * @param in scanner
     */
    public static void buyItem(Player p, Equipment e, Scanner in) {
        if (e.getPrice() > p.getGold()) {//gold amount is insufficient 
            System.out.println("Insuffcient Gold. Purchase Process Quited.");
        } else {//enough gold
            if (e instanceof Gun) {
                if (p.getGuns1().equals("")) {
                    p.setGold(p.getGold() - e.getPrice());
                    p.setGuns1(e.getName());
                } else if (p.getGuns2().equals("")) {
                    p.setGold(p.getGold() - e.getPrice());
                    p.setGuns1(e.getName());
                } else {
                    System.out.println("\nNo space for a new Item, now you have three choice");
                    System.out.println("1. Replace " + p.getGuns1());
                    System.out.println("2. Replace " + p.getGuns2());
                    System.out.println("0. Quit purchasing process");
                    switch (menuInput(in, 2)) {
                        case 1:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getGuns1() + " is replaced with " + e.getName());
                            p.setGuns1(e.getName());
                            break;
                        case 2:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getGuns2() + " is replaced with " + e.getName());
                            p.setGuns2(e.getName());
                            break;
                        case 0:
                            return;
                    }
                }
            }
            else if (e instanceof MeleeWeapon) {
                if (p.getMeleeWeapon().equals("")) {
                    p.setGold(p.getGold() - e.getPrice());
                    p.setMeleeWeapon(e.getName());
                } else {
                    System.out.println("\nNo space for a new Item, now you have two choice");
                    System.out.println("1. Replace " + p.getMeleeWeapon());
                    System.out.println("0. Quit purchasing process");
                    switch (menuInput(in, 1)) {
                        case 1:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getMeleeWeapon() + " is replaced with " + e.getName());
                            p.setMeleeWeapon(e.getName());
                            break;
                        case 0:
                            return;
                    }
                }
            }
            else if (e instanceof Grenade) {
                if (p.getGrenade().equals("")) {
                    p.setGold(p.getGold() - e.getPrice());
                    p.setGrenade(e.getName());
                } else {
                    System.out.println("\nNo space for a new Item, now you have two choice");
                    System.out.println("1. Replace " + p.getGrenade());
                    System.out.println("0. Quit purchasing process");
                    switch (menuInput(in, 1)) {
                        case 1:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getGrenade() + " is replaced with " + e.getName());
                            p.setGrenade(e.getName());
                            break;
                        case 0:
                            return;
                    }
                }
            }
            else if (e instanceof Helmet) {
                if (p.getHelmet().equals("")) {
                    p.setGold(p.getGold() - e.getPrice());
                    p.setHelmet(e.getName());

                } else {
                    System.out.println("\nNo space for a new Item, now you have two choice");
                    System.out.println("1. Replace " + p.getHelmet());
                    System.out.println("0. Quit purchasing process");
                    switch (menuInput(in, 1)) {
                        case 1:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getHelmet() + " is replaced with " + e.getName());
                            p.setHelmet(e.getName());
                            break;
                        case 0:
                            return;
                    }
                }
            }
            else if (e instanceof Vest) {
                if (p.getVest().equals("")) {
                    p.setGold(p.getGold() - e.getPrice());
                    p.setVest(e.getName());

                } else {
                    System.out.println("\nNo space for a new Item, now you have two choice");
                    System.out.println("1. Replace " + p.getVest());
                    System.out.println("0. Quit purchasing process");
                    switch (menuInput(in, 1)) {
                        case 1:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getVest() + " is replaced with " + e.getName());
                            p.setVest(e.getName());
                            break;
                        case 0:
                            return;
                    }
                }
            }
            else if (e instanceof Bullet) {
                if (p.getBullets1().equals(e.getName())) {//if the person has the same type of bullet, num will just add on
                    p.setGold(p.getGold() - e.getPrice());
                    p.setNumBullets1(((Bullet) e).getNumberPerPackage() + p.getNumBullets1());
                } else if (p.getBullets2().equals(e.getName()) || p.getBullets2().equals("")) {
                    p.setGold(p.getGold() - e.getPrice());
                    p.setBullets2(e.getName());
                    p.setNumBullets2(p.getNumBullets2() + ((Bullet) e).getNumberPerPackage());
                } else if (p.getBullets1().equals("")) {
                    p.setBullets1(e.getName());
                    p.setGold(p.getGold() - e.getPrice());
                    p.setNumBullets1(((Bullet) e).getNumberPerPackage());
                } else {
                    System.out.println("\nNo space for a new Item, now you have three choice");
                    System.out.println("1. Replace " + p.getBullets1());
                    System.out.println("2. Replace " + p.getBullets2());
                    System.out.println("0. Quit purchasing process");
                    switch (menuInput(in, 2)) {
                        case 1:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getBullets1() + " is replaced with " + e.getName());
                            p.setBullets1(e.getName());
                            p.setNumBullets1(((Bullet) e).getNumberPerPackage());
                            break;
                        case 2:
                            p.setGold(p.getGold() - e.getPrice());
                            System.out.println("\nYour " + p.getBullets2() + " is replaced with " + e.getName());
                            p.setBullets2(e.getName());
                            p.setNumBullets2(((Bullet) e).getNumberPerPackage());
                            break;
                        case 0:
                            return;
                    }
                }
            }
            System.out.println("\nPurchase successfully\n");
        }
    }

    /**
     * finds a equipment and decides whether to buy
     * @param ws weapon shop list
     * @param in scanner
     * @param p player
     */    
    public static void findFromAllAndBuy(WeaponShop ws, Scanner in, Player p) {
        System.out.println("Please Input Item name: ");

        Equipment e = ws.searchEquipmentByName(in.nextLine());

        while (e == null) {
            System.out.println("\nSorry, we don't have this gear. You may have entered wrong name");
            System.out.println("Do you want to re-enter the name?");
            System.out.println("0. Yes");
            System.out.println("1. No");
            if (menuInput(in, 1) == 0) {
                System.out.println("\nPlease Input Item name: ");
                e = ws.searchEquipmentByName(in.nextLine());
            } else {
                break;
            }
        }
        if (e != null) {
            System.out.println("\nThis is the item you searched:\n");
            e.showInfo();
            System.out.println("\n1. Buy the item");
            System.out.println("0. Return to main menu");
            if (menuInput(in, 1) == 1) {
                buyItem(p, e, in);
            }
        }
    }

    /**
     * finds an equipment under a category and decides whether to buy
     * @param ws weapon shop list
     * @param in scanner
     * @param p player
     * @param type type of the equipment / the category
     */
    public static void findFromOneTypeAndBuy(WeaponShop ws, Scanner in, Player p, int type) {
        System.out.print("This is the list of ");
        switch(type){
            case 0:
                System.out.print("guns");
                break;
            case 1:
                System.out.print("melee weapons");
                break;
            case 2:
                System.out.print("grenades");
                break;
            case 3:
                System.out.print("helmets");
                break;
            case 4:
                System.out.print("vests");
                break;
            case 5:
                System.out.print("bullets");
                break;
                
        }
        System.out.println(" available:");
        System.out.println("-------------------------------------");
        ws.showList(type);
        System.out.println("-------------------------------------");
        System.out.print("1. Buy a ");
        switch(type){
            case 0:
                System.out.print("gun");
                break;
            case 1:
                System.out.print("melee weapon");
                break;
            case 2:
                System.out.print("grenade");
                break;
            case 3:
                System.out.print("helmet");
                break;
            case 4:
                System.out.print("vest");
                break;
            case 5:
                System.out.print("pack of bullets");
                break;
                
        }
        System.out.println("\n0. Go Back");
        if (menuInput(in, 1) == 1) {

            System.out.println("Please Input Item name: ");

            Equipment e = ws.searchOneTypeByName(in.nextLine(), type);

            while (e == null) {
                System.out.println("\nSorry, we don't have this gear in this type. You may have entered wrong name");
                System.out.println("Do you want to re-enter the name?");
                System.out.println("0. Yes");
                System.out.println("1. No");
                if (menuInput(in, 1) == 0) {
                    System.out.println("\nPlease Input Item name: ");
                    e = ws.searchOneTypeByName(in.nextLine(), type);
                } else {
                    break;
                }
            }
            if (e != null) {
                System.out.println("\nThis is the item you searched:\n");
                e.showInfo();
                System.out.println("\n1. Buy the item");
                System.out.println("0. Quit Purchasing And Go Back");
                if (menuInput(in, 1) == 1) {
                    buyItem(p, e, in);
                }
            }
        }
    }
    /**
     * the menu, allows user to load the player's file, search for an item, sort different equipments in different ways and buy 
     */
    public static void menu() {

        final int GUN = 0;
        final int MELEE_WEAPON = 1;
        final int GRENADE = 2;
        final int HELMET = 3;
        final int VEST = 4;
        final int BULLETS = 5;
        boolean stay = true;

        WeaponShop ws = new WeaponShop();
        ws.loadEquipments();
        Scanner in = new Scanner(System.in);
        System.out.println("load player profile: ");

        Player p;
        while (true) {
            try {
                String playerName = in.nextLine();
                File f = new File("src/" + playerName + ".txt");
                in = new Scanner(f);
                p = new Player(playerName, in, f);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Please input again");
            }
        }
        System.out.println("File loaded\n");
        p.showInfo();
        System.out.println("\nWelcome to Equipment Shop. Enter number to excute each request.");

        in = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("1. Show Player Info");
            System.out.println("2. Save Player Info");
            System.out.println("3. Show Item list");
            System.out.println("4. Search Item");
            System.out.println("0. Exit");
            switch (menuInput(in, 4)) {
                case 1:
                    
                    p.showInfo();
                    break;
                case 2:
                    p.savePlayerInfo();
                    System.out.println("Player Info Saved");
                    break;
                case 3:
                    while (stay) {
                        System.out.println("-------------------------------------");
                        System.out.println("1. Show Guns");
                        System.out.println("2. Show Melee Weapons");
                        System.out.println("3. Show Grenades");
                        System.out.println("4. Show Helmets");
                        System.out.println("5. Show Vests");
                        System.out.println("6. Show Bullets");
                        System.out.println("0. Go Back");

                        switch (menuInput(in, 6)) {
                            case 1:

                                while (stay) {//the choices can be expanded, but for now these ar the most useful ones. according to users' opinion, this can be changed later
                                    System.out.println("-------------------------------------");
                                    System.out.println("How do you want to sort guns?");
                                    System.out.println("1. Based On Name");
                                    System.out.println("2. Based On Ammo Type");// so that user can find the gun with right ammo
                                    System.out.println("3. Cheap First");
                                    System.out.println("4. Expensive First");
                                    System.out.println("5. Low DPS First");
                                    System.out.println("6. High DPS First");//for a gun, dps is always important
                                    System.out.println("7. Short Reload Time First");
                                    System.out.println("8. Long Reload Time First");// some people may want a low reload time gun
                                    System.out.println("9. Short Range First");// easy to find snipers or pristols 
                                    System.out.println("10.Long Range First");
                                    System.out.println("11.Low Attack Speed First");//people who like machine gun or sniper may want this
                                    System.out.println("12. High Attack Speed First");
                                    System.out.println("0. Go Back");
                                    switch (menuInput(in, 12)) {
                                        case 1:
                                            ws.sortByName(GUN);  
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 2:
                                            ws.sortByAmmoType(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 3:
                                            ws.cheapFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 4:
                                            ws.expensiveFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 5:
                                            ws.lowDpsFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 6:
                                            ws.highDpsFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 7:
                                            ws.lowReloadTimeFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 8:
                                            ws.highReloadTimeFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 9:
                                            ws.shortRangeFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 10:
                                            ws.longRangeFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 11:
                                            ws.lowAttackSpeedFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 12:
                                            ws.highAttackSpeedFirst(GUN);
                                            findFromOneTypeAndBuy(ws, in, p, GUN);
                                            break;
                                        case 0:
                                            stay = false;
                                            break;

                                    }
                                }
                                stay = true;
                                break;

                            case 2:
                                
                                while(stay){//explain why each 
                                    System.out.println("-------------------------------------");
                                    System.out.println("How do you want to sort melee weapons?");
                                    System.out.println("1. Based On Name");
                                    System.out.println("2. Cheap First");
                                    System.out.println("3. Expensive First");
                                    System.out.println("4. Low DPS First");
                                    System.out.println("5. High DPS First");
                                    System.out.println("6. Short Range First");
                                    System.out.println("7. Long Range First");// for melee weapon, range makes huge differences
                                    System.out.println("8. Low Attack Speed First");// attack speed is important for melee weapon, people have different preferences
                                    System.out.println("9. High Attack Speed First");//this usually is related with damage per attack, low speed means high damage per attack, so a sorting based on damage is unnecessary
                                    System.out.println("0. Go Back");
                                    switch(menuInput(in, 9)){
                                        case 1:
                                            ws.sortByName(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 2:
                                            ws.cheapFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 3:
                                            ws.expensiveFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 4:
                                            ws.lowDpsFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 5:
                                            ws.highDpsFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 6:
                                            ws.shortRangeFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 7:
                                            ws.longRangeFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 8:
                                            ws.lowAttackSpeedFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                        case 9:
                                            ws.highAttackSpeedFirst(MELEE_WEAPON);
                                            findFromOneTypeAndBuy(ws, in, p, MELEE_WEAPON);
                                            break;
                                            
                                        case 0:
                                            stay = false;
                                            break;
                                    }
                                }
                                stay = true;
                                break;
                            case 3:
                                while(stay){
                                    System.out.println("-------------------------------------");
                                    System.out.println("How do you want to sort grenades?");
                                    System.out.println("1. Based On Name");
                                    System.out.println("2. Cheap First");
                                    System.out.println("3. Expensive First");
                                    System.out.println("4. Short Range First");
                                    System.out.println("5. Long Range First");//how much area grenade covers is important
                                    System.out.println("6. Low Damage First");
                                    System.out.println("7. High Damage First");//how much damage it may cause is important, makes more sense than dps
                                    System.out.println("8. Short Delay First");//delay for grenades is a important factor, someone may need shorter delay
                                    System.out.println("9. Long Delay First");
                                    System.out.println("0. Go Back");
                                    switch(menuInput(in, 9)){
                                        case 1:
                                            ws.sortByName(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 2:
                                            ws.cheapFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 3:
                                            ws.expensiveFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 4:
                                            ws.shortRangeFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 5:
                                            ws.longRangeFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 6:
                                            ws.lowDamagePerAttackFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 7:
                                            ws.highDamagePerAttackFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 8:
                                            ws.lowDelayFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 9:
                                            ws.highDelayFirst(GRENADE);
                                            findFromOneTypeAndBuy(ws, in, p, GRENADE);
                                            break;
                                        case 0:
                                            stay = false;
                                            break;
                                        
                                    }
                                }
                                stay = true;
                                break;
                            case 5://vest
                                while (stay) {
                                    System.out.println("-------------------------------------");
                                    System.out.println("How do you want to sort vests?");
                                    System.out.println("1. Based On Name");
                                    System.out.println("2. Cheap First");
                                    System.out.println("3. Expensive First");
                                    System.out.println("4. Low Level First");
                                    System.out.println("5. High Level First");
                                    System.out.println("6. Low Amount of Shield First");
                                    System.out.println("7. High Amount of Shield First");
                                    System.out.println("0. Go Back");
                                    switch (menuInput(in, 7)) {
                                        case 1:
                                            ws.sortByName(VEST);
                                            findFromOneTypeAndBuy(ws, in, p, VEST);
                                            break;
                                        case 2:
                                            ws.cheapFirst(VEST);
                                            findFromOneTypeAndBuy(ws, in, p, VEST);
                                            break;
                                        case 3:
                                            ws.expensiveFirst(VEST);
                                            findFromOneTypeAndBuy(ws, in, p, VEST);
                                            break;
                                        case 4:
                                            ws.lowLevelFirst(VEST);
                                            findFromOneTypeAndBuy(ws, in, p, VEST);
                                            break;
                                        case 5:
                                            ws.highLevelFirst(VEST);
                                            findFromOneTypeAndBuy(ws, in, p, VEST);
                                            break;
                                        case 6:
                                            ws.lowShieldFirst(VEST);
                                            findFromOneTypeAndBuy(ws, in, p, VEST);
                                            break;
                                        case 7:
                                            ws.highShieldFirst(VEST);
                                            findFromOneTypeAndBuy(ws, in, p, VEST);
                                            break;
                                        case 0:
                                            stay = false;
                                            break;
                                    }
                                }
                                stay = true;

                                break;
                            case 4://helmet
                                while (stay) {
                                    System.out.println("-------------------------------------");
                                    System.out.println("How do you want to sort helmets?");
                                    System.out.println("1. Based On Name");
                                    System.out.println("2. Cheap First");
                                    System.out.println("3. Expensive First");
                                    System.out.println("4. Low Level First");
                                    System.out.println("5. High Level First");
                                    System.out.println("6. Low Amount of Shield First");
                                    System.out.println("7. High Amount of Shield");
                                    System.out.println("0. Go Back");
                                    switch (menuInput(in, 7)) {
                                        case 1:
                                            ws.sortByName(HELMET);
                                            findFromOneTypeAndBuy(ws, in, p, HELMET);
                                            break;
                                        case 2:
                                            ws.cheapFirst(HELMET);
                                            findFromOneTypeAndBuy(ws, in, p, HELMET);
                                            break;
                                        case 3:
                                            ws.expensiveFirst(HELMET);
                                            findFromOneTypeAndBuy(ws, in, p, HELMET);
                                            break;
                                        case 4:
                                            ws.lowLevelFirst(HELMET);
                                            findFromOneTypeAndBuy(ws, in, p, HELMET);
                                            break;
                                        case 5:
                                            ws.highLevelFirst(HELMET);
                                            findFromOneTypeAndBuy(ws, in, p, HELMET);
                                            break;
                                        case 6:
                                            ws.lowShieldFirst(HELMET);
                                            findFromOneTypeAndBuy(ws, in, p, HELMET);
                                            break;
                                        case 7:
                                            ws.highShieldFirst(HELMET);
                                            findFromOneTypeAndBuy(ws, in, p, HELMET);
                                            break;
                                        case 0:
                                            stay = false;
                                            break;
                                    }
                                }
                                stay = true;

                                break;
                            case 6://bullets
                                while(stay){
                                    System.out.println("-------------------------------------");
                                    System.out.println("How do you want to sort bullets?");
                                    System.out.println("1. Based On Name");//it is unnecessary to sort bullets according to number per package 
                                    System.out.println("2. Cheap First");
                                    System.out.println("3. Expensive First");
                                    System.out.println("0. Go Back");
                                    switch(menuInput(in, 3)){
                                        case 1:
                                            ws.sortByName(BULLETS);
                                            findFromOneTypeAndBuy(ws, in, p, BULLETS);
                                            break;
                                        case 2:
                                            ws.cheapFirst(BULLETS);
                                            findFromOneTypeAndBuy(ws, in, p, BULLETS);
                                            break;
                                        case 3:
                                            ws.expensiveFirst(BULLETS);
                                            findFromOneTypeAndBuy(ws, in, p, BULLETS);
                                            break;
                                        case 0:
                                            stay = false;
                                            break;
                                    }
                                }
                                
                                stay = true;
                                break;

                            case 0:
                                stay = false;
                                break;

                        }

                    }
                    stay = true;
                    break;
                case 4:
                    findFromAllAndBuy(ws, in, p);

                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("UNIDENTIFIED ERROR");
                    System.exit(0);
                    break;
            }
        }

    }

    /**
     * main class, runs menu
     * @param args 
     */
    public static void main(String[] args) {
        menu();

    }
}
