package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: GarageDoor.java
 */

public class GarageDoor {

    private boolean on;
    private String description;

    //Constructor Method for the Garagedoor
    public GarageDoor(String description) {
        this.description = description;
    }

    //Method to open the Garage Door, printing the status to the console.
    public void doorOpen() {
        this.on = true;
        System.out.println(description + "Opened.");
    }

    //Method to close the Garage Door, printing the status to the console.
    public void doorClose() {
        this.on = false;
        System.out.println(description + "Closed.");
    }

}
