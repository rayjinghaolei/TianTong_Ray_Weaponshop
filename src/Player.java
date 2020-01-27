
import java.io.*;
import java.util.*;

public class Player {

    //these are the things that player can have. they can have no more equipment than these.
    private String playerName;
    private int gold;
    private String helmet;
    private String vest;
    private String bullets1;
    private int numBullets1;
    private String bullets2;
    private int numBullets2;
    private String guns1;
    private String guns2;
    private String meleeWeapon;
    private String grenade;

    /**
     * gets player's name
     * @return player's name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * gets amount of gold 
     * @return amount of gold
     */
    public int getGold() {
        return gold;
    }
    
    /**
     * sets the amount of gold
     * @param gold new amount of gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * gets the name of helmet the player has
     * @return the name of helmet
     */
    public String getHelmet() {
        return helmet;
    }

    /**
     * sets the helmet
     * @param helmet the new helmet the player gets
     */
    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }

    /**
     * gets the name of the vest that the player has
     * @return the name of the vest
     */
    public String getVest() {
        return vest;
    }

    /**
     * sets the vest
     * @param vest the name of the new vest
     */
    public void setVest(String vest) {
        this.vest = vest;
    }

    /**
     * gets the name of the bullet type 1 that the player has
     * @return name of bullet 1
     */
    public String getBullets1() {
        return bullets1;
    }

    /**
     * sets the name of the bullet 1
     * @param bullets1 new bullet 1
     */
    public void setBullets1(String bullets1) {
        this.bullets1 = bullets1;
    }

    /**
     * gets the amount of bullets 1 that the player has
     * @return number of bullets 1
     */
    public int getNumBullets1() {
        return numBullets1;
    }

    /**
     * sets the amount of bullets 1
     * @param numBullets1 new amount of bullets 1
     */
    public void setNumBullets1(int numBullets1) {
        this.numBullets1 = numBullets1;
    }

    /**
     * gets the name of bullet type 2
     * @return name of bullet type 2
     */
    public String getBullets2() {
        return bullets2;
    }

    /**
     * sets the name of bullet 2
     * @param bullets2 new name of bullet 2
     */
    public void setBullets2(String bullets2) {
        this.bullets2 = bullets2;
    }
    
    /**
     * gets the amount of bullets 2
     * @return amount of bullets 2 that the player has
     */
    public int getNumBullets2() {
        return numBullets2;
    }
    /**
     * sets the amount of bullets 2
     * @param numBullets2 new amount of bullet 2
     */
    public void setNumBullets2(int numBullets2) {
        this.numBullets2 = numBullets2;
    }

    /**
     * gets the name of gun 1
     * @return name of gun 1
     */
    public String getGuns1() {
        return guns1;
    }

    /**
     * sets the name of gun 1
     * @param guns1 name of new gun 1
     */
    public void setGuns1(String guns1) {
        this.guns1 = guns1;
    }

    /**
     * gets the name of gun 2 thar the player has
     * @return the name of gun 2
     */
    public String getGuns2() {
        return guns2;
    }

    /**
     * sets the name of gun 2
     * @param guns2 the name of new gun 2
     */
    public void setGuns2(String guns2) {
        this.guns2 = guns2;
    }

    /**
     * gets the name of melee weapon
     * @return name of melee weapon
     */
    public String getMeleeWeapon() {
        return meleeWeapon;
    }

    /**
     * sets the name of melee weapon
     * @param meleeWeapon the name of new melee weapon
     */
    public void setMeleeWeapon(String meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    /**
     * gets the name of grenade
     * @return the name of grenade
     */
    public String getGrenade() {
        return grenade;
    }

    /**
     * sets the name of grenade
     * @param grenade sets the name of grenade
     */
    public void setGrenade(String grenade) {
        this.grenade = grenade;
    }

    /**
     * constructs a player by reading the player's file
     * @param playerName name of the player / name of the file
     * @param in scanner
     * @param f the file
     */
    public Player(String playerName, Scanner in, File f) {
        this.playerName = playerName;
        
        String information;
        String[] info;

        try {
            in = new Scanner(f);//?
            while (in.hasNext()) {
                information = in.nextLine();
                info = information.split(",");
                
                    this.gold = Integer.parseInt(info[0]);
                    this.helmet = info[1];
                   
                    this.vest = info[2];
                  
                    this.bullets1 = info[3];
                    this.numBullets1 = Integer.parseInt(info[4]);
                    this.bullets2 = info[5];
                    this.numBullets2 = Integer.parseInt(info[6]);
                    this.guns1 = info[7];
                    this.guns2 = info[8];
                    this.meleeWeapon = info[9];
                    this.grenade = info[10];
                
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * converts the player's info into csv format
     * @return the info of player in csv form
     */
    @Override
    public String toString() {
        return gold + "," 
                + helmet + "," 
                + vest + "," 
               
                + bullets1 + "," 
                + numBullets1 + "," 
                + bullets2 + "," 
                + numBullets2 + "," 
                + guns1 + "," 
                + guns2 + "," 
                + meleeWeapon + "," 
                + grenade;
    }

    /**
     * shows all info of a player
     */
    public void showInfo() {
        System.out.println("Player's Name: " + playerName
                + "\nGold Amount: " + gold
                + "\nHelmet: " + helmet
              
                + "\nVest: " + vest
               
                + "\nBullets Type 1: " + bullets1
                + "\nAmount of bullet type 1: " + numBullets1
                + "\nBullets Type 2: " + bullets2
                + "\nAmount of bullet type 2: " + numBullets2
                + "\nGun 1: " + guns1
                + "\nGun 2: " + guns2
                + "\nMelee Weapon: " + meleeWeapon
                + "\nGrenade: " + grenade);
    }
    
    /**
     * save player's info in the file
     */
    public void savePlayerInfo() {
        String f = "src/" + playerName + ".txt";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(f, false));
            out.write(toString());
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
