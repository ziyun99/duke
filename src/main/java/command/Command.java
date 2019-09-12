package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import ui.Ui;

/**
 * Command abstract class that encapsulates user's input into a command object.
 */
public abstract class Command {

    protected String inData;
    protected boolean isExit;

    /**
     * Command object Constructor.
     * @param inData the user input that triggers this command.
     */
    public Command(String inData) {
        this.inData = inData;
        isExit = false;
    }

    /**
     * This is an abstract function.
     * @param tasks TaskList object.
     * @param ui Ui object that manages user interactions.
     * @param storage Storage object that manages local data access.
     * @throws DukeException if there is error in user input.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * This function indicates the exit status of the program. The program exits if the status is true.
     *
     * @return the exit status of the program.
     */
    public boolean isExit() {
        return isExit;
    }

}
