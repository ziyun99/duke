import TaskList.TaskList;
import command.Command;
import exception.DukeException;
import storage.Storage;
import ui.Ui;

import java.io.FileNotFoundException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

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
            System.out.println("File not found, creating a new file for data storage.");
            tasks = new TaskList();
        }
    }

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
        System.out.println("\nSaving data to hard disk...");
        storage.saveData(tasks);
        System.out.println("Save finished...");
        ui.printBye();
    }

    public static void main(String[] args) {
        new Duke("../../../data/tasks.txt").run();
    }

}