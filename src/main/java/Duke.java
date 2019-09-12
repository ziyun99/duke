
import task.TaskList;
import command.Command;
import exception.DukeException;
import storage.Storage;
import ui.Ui;
import parser.Parser;

import java.io.FileNotFoundException;

/**
 * Main class Duke.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    /**
     * Constructor for class Duke.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        try {
            System.out.println("Loading data from hard disk...");
            tasks = new TaskList(storage.load());
            System.out.println("Load finished...");
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            System.out.println("File not found, creating a new task list.");
            tasks = new TaskList();
        }
    }

    /**
     * Main run method. Start the program by welcoming the user, then read user input, parse and process the
     * input command. lastly exits the program when "bye" is inputted.
     */
    public void run() {
        ui.printHello();
        boolean isExit = false;
        while (!isExit) {
            try {
                String inData = ui.readInput();
                Command c = parser.handleCommand(inData);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
                System.out.println("");
            } catch (DukeException e) {
                ui.printError(e);
            }
        }
    }

    /**
     * Main method in Duke class.
     */
    public static void main(String[] args) {
        new Duke("../../../data/tasks.txt").run();
    }

}