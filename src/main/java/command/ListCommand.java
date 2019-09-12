package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import ui.Ui;

/**
 * ListCommand class contains helper functions for listing all the tasks.
 */
public class ListCommand extends Command {

    /**
     * ListCommand class Constructor.
     *
     * @param inData the user input that triggers this command.
     */
    public ListCommand(String inData) {
        super(inData);
    }

    /**
     * This function list all the tasks in TaskList.
     *
     * @param tasks TaskList object.
     * @param ui Ui object that manages user interactions.
     * @param storage Storage object that manages local data access.
     * @throws DukeException if there is error in user input.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int i = 0;

        if (tasks.getTaskList().size() == 0) {
            throw new DukeException(DukeException.dukeExceptionType.LIST_EMPTY);
        }

        ui.printLine();
        ui.printIndented("Here are the tasks in your list: ");
        for (Task task : tasks.getTaskList()) {
            i++;
            ui.printIndented(i + "." + task.toString());
        }
        ui.printLine();
    }
}

