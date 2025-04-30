package diner;

import java.util.ArrayList;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Diner
 * File Name: MenuItem.java
 */

 /*
 * This program recieves menu items and can create and add them
 * This program cycles through the entire menu when printing
 */
public class MenuItem {

    private String description;
    private double price;
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    //This method is a constructor for description
    public MenuItem(String description) {
        this.description = description;
    }

    //This method is a constructor for description and price
    public MenuItem(String description, double price) {
        this.description = description;
        this.price = price;
    }

    //This method adds a menu item to the menuItems array list
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    //This is an overloaded method that will create a new menu item with a description
    //Then it will send the item to the original addMenuItem method to be added to the menuItems array list
    public void addMenuItem(String description) {
        MenuItem item = new MenuItem(description);
        addMenuItem(item);
    }

    //This is an overloaded method that will create a new menu item with a description and price
    //Then it will send the item to the original addMenuItem method to be added to the menuItems array list
    public void addMenuItem(String description, double price) {
        MenuItem item = new MenuItem(description, price);
        addMenuItem(item);
    }

    //This method will call to the print method, starting the printing of the menu to the console
    @Override
    public String toString() {
        return this.print("");
    }

    //This method is a recursive method to list all children and children's children
    public String print(String indent) {
        String temp = indent + this.description + " " + (this.price > 0 ? this.price : "") + "\n\t";
        for (MenuItem subItem : menuItems) {
            temp += subItem.print(indent + "  ");
        }
        return temp;
    }

}
