/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiantong_ray_weaponshoprunner;

/**
 *
 * @author htian
 */
abstract public class Equipments {
  private String name;
  private int price;
    
  public Equipments (String name, int price){
      this.name = name;
      this.price = price;
  }

  public String getName(){
    return name;
  }

  public int getPrice(){
    return price;
  }


  public String showInfo(){
    return "Name: " + name + "\nPrice: " + price;
  }

  @Override
  public String toString(){
    return name + "," + price;
  }

}
