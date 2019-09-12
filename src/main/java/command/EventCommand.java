package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Events;
import task.Task;
import task.Todo;
import ui.Ui;

/**
 * EventCommand class contains helper functions for creating event task.
 */
public class EventCommand extends Command {

    /**
     * EventCommand class Constructor.
     *
     * @param inData the user input that triggers this command.
     */
    public EventCommand(String inData) {
        super(inData);
    }

    /**
     * This function creates Event object by parsing the user input to get task information, and print
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
            throw new DukeException(DukeException.dukeExceptionType.EVENT_EMPTY);
        }
        String[] splitAt = inData.substring(6).split(" /at ");
        if (splitAt.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.EVENT_FORMAT);
        }
        String description = splitAt[0].strip();
        String at = splitAt[1].strip();
        Task newTask = new Events(description, at);
        tasks.getTaskList().add(newTask);

        ui.printLine();
        ui.printIndented("Got it. I've added this task: ");
        ui.printIndented("  " + newTask.toString());
        ui.printIndented("Now you have " + tasks.getTaskList().size() + " tasks in the list.");
        ui.printLine();
    }
}
