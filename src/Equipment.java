
abstract public class Equipment {

    private String name;
    private int price;
    
    /**
     * constructs an equipment 
     * @param name name of the equipment
     * @param price the price of the equipment
     */
    public Equipment(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    /**
     * gets the name
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * gets the price
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * shows the info of a equipment
     */
    public void showInfo() {
        System.out.println("Name: " + name + "\nPrice: " + price);
    }
    
    /**
     * converts the info of object into csv format 
     * @return equipment in csv
     */
    @Override
    public String toString() {
        return name + "," + price;
    }

}
