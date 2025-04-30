package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: Light.java
 */

public class Light {

    private boolean on;
    private String description;

    //Constructor Method for the Light
    public Light(String description) {
        this.description = description;
    }

    //Method to switch the light on, printing the status to the console.
    public void switchOn() {
        this.on = true;
        System.out.println(description + "switched On.");
    }

    //Method to switch the light off, printing the status to the console.
    public void switchOff() {
        this.on = false;
        System.out.println(description + "switched Off.");
    }

}
