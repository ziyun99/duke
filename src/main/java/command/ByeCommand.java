package command;

import TaskList.TaskList;
import exception.DukeException;
import storage.Storage;
import ui.Ui;

public class ByeCommand extends Command {

    public ByeCommand(String inData) {
        super(inData);
        isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        System.out.println("\nSaving data to hard disk...");
        storage.saveData(tasks);
        System.out.println("Save finished...");
        ui.printBye();
    }

//    @Override
//    public boolean isExit() {
//        return true;
//    }
}