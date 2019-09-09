package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Events;
import task.Task;
import task.Todo;
import ui.Ui;

public class EventCommand extends Command {

    public EventCommand(String inData) {
        super(inData);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {   }

        String[] splitAt = inData.substring(6).split(" /at ");
        if(splitAt.length == 1) {
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
