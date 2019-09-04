import java.io.FileNotFoundException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private CommandParser commandParser;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        commandParser = new CommandParser();
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
                commandParser.handleCommand(inData, tasks);
                isExit = commandParser.isExit();
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