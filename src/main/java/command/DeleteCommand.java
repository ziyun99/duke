package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import ui.Ui;

/**
 * DeleteCommand class contains helper functions for deleting task.
 */
public class DeleteCommand extends Command {

    /**
     * DeleteCommand class Constructor.
     *
     * @param inData the user input that triggers this command.
     */
    public DeleteCommand(String inData) {
        super(inData);
    }

    /**
     * This function delete a task from the taskList.
     *
     * @param tasks TaskList object.
     * @param ui Ui object that manages user interactions.
     * @param storage Storage object that manages local data access.
     * @throws DukeException if there is error in user input.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] split = inData.split(" ");

        if (split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DELETE_EMPTY);
        }

        int index = 0;
        try {
            index = Integer.parseInt(split[1].strip());
        } catch (NumberFormatException e) {
            throw new DukeException(DukeException.dukeExceptionType.INT_EXPECTED);
        }

        if (index > 0 && index <= tasks.getTaskList().size()) {
            Task deleteTask;
            deleteTask = tasks.getTaskList().get(index - 1);
            tasks.getTaskList().remove(index - 1);
            ui.printLine();
            ui.printIndented("Noted. I've removed this task: ");
            ui.printIndented(deleteTask.toString());
            ui.printIndented("Now you have " + tasks.getTaskList().size() + " tasks in the list.");
            ui.printLine();
        } else {
            throw new DukeException(DukeException.dukeExceptionType.INDEX_OUT_OF_BOUND);
        }
    }
}
