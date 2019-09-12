package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import task.Todo;
import ui.Ui;

/**
 * TodoCommand class contains helper functions for creating todo task.
 */
public class TodoCommand extends Command {

    /**
     * TodoCommand class Constructor.
     *
     * @param inData the user input that triggers this command.
     */
    public TodoCommand(String inData) {
        super(inData);
    }

    /**
     * This function creates Todo object by parsing the user input to get task information, and print
     * out relevant updated message.
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
            throw new DukeException(DukeException.dukeExceptionType.TODO_EMPTY);
        }

        String description = inData.substring(5).strip();
        Task newTask = new Todo(description);
        tasks.getTaskList().add(newTask);

        ui.printLine();
        ui.printIndented("Got it. I've added this task: ");
        ui.printIndented("  " + newTask.toString());
        ui.printIndented("Now you have " + tasks.getTaskList().size() + " tasks in the list.");
        ui.printLine();
    }
}