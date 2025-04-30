package autohome;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: ICommand.java
 */

public interface ICommand {

    //Method to execute an action.
    public void execute();

    //Method to undo an action.
    public void undo();

}
