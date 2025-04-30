package autohome;
import java.util.ArrayList;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: AutoHome
 * File Name: RemoteControl.java
 */

public class RemoteControl {

    private ICommand[] buttonCommands;
    private ArrayList<ICommand> history = new ArrayList<>();

    //Contructor for the remote with multiple buttons.
    public RemoteControl(int buttonCount) {
        buttonCommands = new ICommand[buttonCount];
    }

    //Method to assign a button on the remote to an action.
    public void setCommand(int button, ICommand command) {
        this.buttonCommands[button] = command;

    }

    //Method to push a specified button on the remote.
    //Adds the button push to the history array list in case of needing to undo an action.
    public void pushButton(int button) {
        this.buttonCommands[button].execute();
        this.history.add(this.buttonCommands[button]);
    }

    //Method to undo any previous button push.
    //Does not execute if the history array list is empty.
    public void undoButton() {

        if (!this.history.isEmpty()) {
            ICommand command = this.history.get(this.history.size() - 1);
            command.undo();
            this.history.remove(this.history.size() - 1);
        }
    }

}
