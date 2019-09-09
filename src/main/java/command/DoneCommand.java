package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import ui.Ui;

public class DoneCommand extends Command{
    public DoneCommand(String inData) {
        super(inData);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DONE_EMPTY);
        }

        int index = 0;
        try {
            index = Integer.parseInt(split[1].strip());
        } catch (NumberFormatException e) {
            throw new DukeException(DukeException.dukeExceptionType.INT_EXPECTED);
        }

        if (index > 0 && index <= tasks.getTaskList().size()) {
            Task doneTask = (Task) tasks.getTaskList().get(index - 1);
            doneTask.setDone();
            ui.printLine();
            ui.printIndented("Nice! I've marked this task as done: ");
            ui.printIndented(doneTask.toString());
            ui.printLine();
        } else {
            throw new DukeException(DukeException.dukeExceptionType.INDEX_OUT_OF_BOUND);
        }
    }
}