package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: GarageDoorCloseCommand.java
 */

public class GarageDoorCloseCommand implements ICommand {

    private GarageDoor garageDoor;

    //Constructor for GarageDoorCloseCommand
    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    //Implemented method from ICommand to execute the garage door closing.
    @Override
    public void execute() {
        garageDoor.doorClose();
    }

    //Implemented method from ICommand to undo the garage door closing.
    @Override
    public void undo() {
        garageDoor.doorOpen();
    }

}
