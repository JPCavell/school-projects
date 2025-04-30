package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: AutoHome.java
 */

public class AutoHome {

    /*
     * This Method is the driver method that will start with creating new Light objects and a GarageDoor object.
     * Firstly, the method will create specific on/off commands for each object.
     * Secondly, a RemoteControl object will be created with 6 buttons.
     * Thirdly, the the commands will be assigned to each button on the remote.
     * Then, The remote will push each button to show its function.
     * Finally, the undo button will be pushed 7 times
     * (6 to undo the button pushes, 1 to show that you can't undo when the button history is empty.
    */
    public static void main(String[] args) {
        Light kitchen = new Light("Kitchen ");
        Light bedroom = new Light("Bedroom ");
        GarageDoor garageDoor = new GarageDoor("Garage Door ");

        LightOnCommand lightOn = new LightOnCommand(kitchen);
        LightOffCommand lightOff = new LightOffCommand(kitchen);
        LightOnCommand lightOnBR = new LightOnCommand(bedroom);
        LightOffCommand lightOffBR = new LightOffCommand(bedroom);
        GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand doorClosed = new GarageDoorCloseCommand(garageDoor);

        RemoteControl control = new RemoteControl(6);

        control.setCommand(0, lightOn);
        control.setCommand(1, lightOff);
        control.setCommand(2, lightOnBR);
        control.setCommand(3, lightOffBR);
        control.setCommand(4, doorOpen);
        control.setCommand(5, doorClosed);

        System.out.println("Button pushes.");
        control.pushButton(0);
        control.pushButton(1);
        control.pushButton(2);
        control.pushButton(3);
        control.pushButton(4);
        control.pushButton(5);

        System.out.println("\nUndo Button.");
        control.undoButton();
        control.undoButton();
        control.undoButton();
        control.undoButton();
        control.undoButton();
        control.undoButton();
        control.undoButton();

    }

}
