package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: LightOnCommand.java
 */

public class LightOnCommand implements ICommand {

    private Light light;

    //Constructor for the LightOnCommand
    public LightOnCommand(Light light) {
        this.light = light;
    }

    //Implemented method from ICommand to execute the light switch turning on.
    @Override
    public void execute() {
        light.switchOn();
    }

    //Implemented method from ICommand to undo the light switch turning on.
    @Override
    public void undo() {
        light.switchOff();
    }

}
