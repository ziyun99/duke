package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Deadline;
import task.Task;
import ui.Ui;

/**
 * DeadlineCommand class contains helper functions for creating deadline task.
 */
public class DeadlineCommand extends Command {

    /**
     * DeadlineCommand class Constructor.
     *
     * @param inData the user input that triggers this command.
     */
    public DeadlineCommand(String inData) {
        super(inData);
    }

    /**
     * This function creates Deadline object by parsing the user input to get task information, and print
     * out relevant updated message.
     *
     * @param tasks TaskList object.
     * @param ui Ui object that manages user interactions.
     * @param storage Storage object that manages local data access.
     * @throws DukeException if there is error in user input.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        isExit = false;

        String[] split = inData.split(" ");

        if (split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DEADLINE_EMPTY);
        }

        String[] splitBy = inData.substring(9).split(" /by ");
        if (splitBy.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DEADLINE_FORMAT);
        }
        String description = splitBy[0].strip();
        String by = splitBy[1].strip();
        Task newTask = new Deadline(description, by);
        tasks.getTaskList().add(newTask);

        ui.printLine();
        ui.printIndented("Got it. I've added this task: ");
        ui.printIndented("  " + newTask.toString());
        ui.printIndented("Now you have " + tasks.getTaskList().size() + " tasks in the list.");
        ui.printLine();
    }

}