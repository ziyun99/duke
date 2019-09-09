package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Deadline;
import task.Task;
import ui.Ui;

public class DeadlineCommand extends Command {
    public DeadlineCommand(String inData) {
        super(inData);
    }

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