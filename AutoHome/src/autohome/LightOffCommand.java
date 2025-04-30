package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: LightOffCommand.java
 */

public class LightOffCommand implements ICommand {

    private Light light;

    //Constructor for the LightOffCommand
    public LightOffCommand(Light light) {
        this.light = light;
    }

    //Implemented method from ICommand to execute the light switch turning off.
    @Override
    public void execute() {
        light.switchOff();
    }

    //Implemented method from ICommand to undo the light switch turning off.
    @Override
    public void undo() {
        light.switchOn();
    }

}
