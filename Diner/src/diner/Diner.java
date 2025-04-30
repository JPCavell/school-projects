package diner;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Diner
 * File Name: Diner.java
 */

 /*
 * This program is the driver
 */
public class Diner {

    // This method will add a variety of menu items by calling to the appropriate method in class MenuItem
    // This method will also print out the menu
    public static void main(String[] args) {
        MenuItem myDiner = new MenuItem("Leslie's Diner");
        MenuItem apps = new MenuItem("Appetizers");
        myDiner.addMenuItem(apps);
        apps.addMenuItem("Quesillias", 8.45);
        apps.addMenuItem("Chicken Wings", 5.33);
        apps.addMenuItem("Nachos", 7.99);
        MenuItem drinks = new MenuItem("Drinks");
        myDiner.addMenuItem(drinks);
        MenuItem beer = new MenuItem("Beer");
        MenuItem wine = new MenuItem("Wine");
        MenuItem softDrinks = new MenuItem("Soft Drinks");
        drinks.addMenuItem(beer);
        drinks.addMenuItem(wine);
        drinks.addMenuItem(softDrinks);
        beer.addMenuItem("Cheap Beer", 1.00);
        beer.addMenuItem("Dark Beer", 2.00);
        beer.addMenuItem("Light Beer", 3.00);
        wine.addMenuItem("White Wine", 4.00);
        wine.addMenuItem("Red Wine", 5.00);
        wine.addMenuItem("Pink Wine", 6.00);
        wine.addMenuItem("Sparkling Wine", 7.00);
        softDrinks.addMenuItem("Coke", 1.00);
        softDrinks.addMenuItem("Diet Coke", 1.00);
        softDrinks.addMenuItem("Dr. Pepper", 1.00);
        MenuItem sprite = new MenuItem("Sprite");
        softDrinks.addMenuItem(sprite);
        sprite.addMenuItem("Large Sprite", 1.00);
        sprite.addMenuItem("Medium Sprite", .50);
        sprite.addMenuItem("Small Sprite", .20);

        System.out.println(myDiner);
    }

}
