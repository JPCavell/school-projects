package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: GarageDoorOpenCommand.java
 */

public class GarageDoorOpenCommand implements ICommand {

    private GarageDoor garageDoor;

    //Constructor for GarageDoorOpenCommand
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    //Implemented method from ICommand to execute the garage door opening.
    @Override
    public void execute() {
        garageDoor.doorOpen();
    }

    //Implemented method from ICommand to undo the garage door opening.
    @Override
    public void undo() {
        garageDoor.doorClose();
    }

}
