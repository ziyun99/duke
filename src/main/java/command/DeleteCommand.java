package command;

import TaskList.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import ui.Ui;

public class DeleteCommand extends Command {

    public DeleteCommand(String inData) {
        super(inData);
    }

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
            Task deleteTask = tasks.getTaskList().get(index - 1);
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
