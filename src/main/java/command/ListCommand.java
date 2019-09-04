package command;

import TaskList.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import ui.Ui;

public class ListCommand extends Command {

    public ListCommand(String inData) {
        super(inData);
    }

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

