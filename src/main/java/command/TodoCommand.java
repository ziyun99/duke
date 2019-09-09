package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import task.Todo;
import ui.Ui;

public class TodoCommand extends Command {

    public TodoCommand(String inData) {
        super(inData);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] split = inData.split(" ");
        if(split.length == 1) {
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