package command;

import task.TaskList;
import exception.DukeException;
import storage.Storage;
import task.Task;
import ui.Ui;

import java.util.ArrayList;

/**
 * FindCommand class contains helper functions for finding task.
 */
public class FindCommand extends Command {

    /**
     * EventCommand class Constructor.
     *
     * @param inData the user input that triggers this command.
     */
    public FindCommand(String inData) {
        super(inData);
    }

    /**
     * This function find tasks that contains keyword given by the user input, and print out the find result.
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
            throw new DukeException(DukeException.dukeExceptionType.FIND_EMPTY);
        }

        String keyword = inData.substring(5).strip();
        ArrayList<Task> findList = new ArrayList<Task>();

        for (Task task : tasks.getTaskList()) {
            if (task.getDescription().contains(keyword)) {
                findList.add(task);
            }
        }
        ui.printLine();
        if (findList.size() == 0) {
            ui.printIndented("Result: No matching tasks in your list.");
        } else {
            ui.printIndented("Here are the matching tasks in your list:");
            int i = 0;
            for (Task task : findList) {
                i++;
                ui.printIndented(i + "." + task.toString());
            }
        }
        ui.printLine();
    }
}
