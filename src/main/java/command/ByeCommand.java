package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import ui.Ui;

/**
 * ByeCommand class handle saving of data and showing bye message before the program exits.
 */
public class ByeCommand extends Command {

    /**
     * ByeCommand class Constructor.
     *
     * @param inData the user input that triggers this command.
     */
    public ByeCommand(String inData) {
        super(inData);
        isExit = true;
    }

    /**
     * This function call storage.saveData() function to save TaskList into local file, then shows bye
     * message and exits the program.
     *
     * @param tasks TaskList object to be saved into local file.
     * @param ui Ui object that manages showing of bye message.
     * @param storage Storage object that manages saving of data to local file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println("\nSaving data to hard disk...");
        storage.saveData(tasks);
        System.out.println("Save finished...");
        ui.printBye();
    }

}