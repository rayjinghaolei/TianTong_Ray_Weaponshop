
public class Bullet extends Equipment{
  private int numberPerPackage;
  
  /**
   * constructs bullet
   * @param name name of bullet
   * @param price price of bullet
   * @param numberPerPackage number of bullets that player gets by buying once
   */
  public Bullet (String name, int price, int numberPerPackage){
    super(name, price);
    this.numberPerPackage = numberPerPackage;
  }
  
  /**
   * gets the number of bullets per purchase 
   * @return number of bullets per purchase
   */
  public int getNumberPerPackage(){
    return numberPerPackage;
  }
  
  /**
   * shows the info of bullets
   */
  public void showInfo(){
    super.showInfo();
    System.out.println("Number per package: " + numberPerPackage);
  }
  
  /**
   * turns the info of bullet into csv form
   * @return bullet in csv
   */
  public String toString(){
    return super.toString() + "," + numberPerPackage;
  }
}