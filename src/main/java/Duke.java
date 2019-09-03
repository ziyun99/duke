import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    private ArrayList<Task> myTasks = new ArrayList<Task>();
    FileHandler myFile = new FileHandler();;

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.hello();

        String inData;
        Scanner scan = new Scanner(System.in);

        while(true) {
            try {
                inData = scan.nextLine();
                if (!inData.equals("bye")) {
                    duke.handleCommand(inData);
                } else {
                    duke.bye();
                    break;
                }
                System.out.println("");
            } catch (DukeException e) {
                System.out.println(e);
            }
        }
    }

    public Duke()  {
        //FileHandler myFile = new FileHandler();
        System.out.println("Loading data from hard disk...");
        this.myTasks = myFile.loadData();
        System.out.println("Load finished...");
    }

    public void handleCommand(String inData) throws DukeException {

        String[] split = inData.split(" ");
        if (split.length == 0 || inData.equals("")) {
            throw new DukeException(DukeException.dukeExceptionType.INPUT_EMPTY);
        } else if (inData.equals("list")) {
            this.listTask();
        } else if (split[0].equals("done")) {
            this.doneTask(inData);
        } else if (split[0].equals("todo")) {
            this.addTodo(inData);
        } else if (split[0].equals("deadline")) {
            this.addDeadline(inData);
        } else if (split[0].equals("event")) {
            this.addEvent(inData);
        } else {
            throw new DukeException(DukeException.dukeExceptionType.UNKNOWN);
        }
    }

    public void addTodo(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.TODO_EMPTY);
        }

        String task = inData.substring(5).strip();
        Task newTask = new Todo(task);
        myTasks.add(newTask);

        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }

    public void addDeadline(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {
            //this.print("☹ OOPS!!! The description of a deadline cannot be empty.");
            throw new DukeException(DukeException.dukeExceptionType.DEADLINE_EMPTY);
        }

        String[] splitBy = inData.substring(9).split(" /by ");
        if(splitBy.length == 1) {
            //this.print("☹ OOPS!!! Incorrect format for deadline.");
            throw new DukeException(DukeException.dukeExceptionType.DEADLINE_FORMAT);
        }
        String task = splitBy[0].strip();
        String by = splitBy[1].strip();
        Task newTask = new Deadline(task, by);
        myTasks.add(newTask);

        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }

    public void addEvent(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {   }

        String[] splitAt = inData.substring(6).split(" /at ");
        if(splitAt.length == 1) {
            //this.print("☹ OOPS!!! Incorrect format for event.");
            throw new DukeException(DukeException.dukeExceptionType.EVENT_FORMAT);
        }
        String task = splitAt[0].strip();
        String at = splitAt[1].strip();
        Task newTask = new Events(task, at);
        myTasks.add(newTask);

        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }

    public void doneTask(String inData) throws DukeException{
        String[] split = inData.split(" ");

        if(split.length == 1) {
            //this.print("☹ OOPS!!! The index of done cannot be empty.");
            throw new DukeException(DukeException.dukeExceptionType.DONE_EMPTY);
        }

        int index = 0;
        try {
            index = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            //this.print("not a number");
            throw new DukeException(DukeException.dukeExceptionType.INT_EXPECTED);
        }

        if (index > 0 && index <= myTasks.size()) {
            Task doneTask = (Task) myTasks.get(index - 1);
            doneTask.setDone();
            printLine();
            printIndented("Nice! I've marked this task as done: ");
            printIndented(doneTask.toString());
            printLine();
        } else {
            //this.print("Alert: Index out of range.");
            throw new DukeException(DukeException.dukeExceptionType.INDEX_OUT_OF_BOUND);
        }
    }

    public void listTask() throws DukeException {
        int i = 0;

        if (myTasks.size() == 0) {
            throw new DukeException(DukeException.dukeExceptionType.LIST_EMPTY);
        }

        printLine();
        printIndented("Here are the tasks in your list: ");
        for (Task task : myTasks) {
            i++;
            printIndented(i + "." + task.toString());
        }
        printLine();

    }

    public void hello() {
        printLine();
        printIndented("Hello! I'm Duke");
        printIndented("What can I do for you?");
        printLine();
        System.out.println("");
    }

    public void bye() {
        System.out.println("\nSaving data to hard disk...");
        myFile.saveData(myTasks);
        System.out.println("Save finished...");
        printLine();
        printIndent();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public void print(String output) {
        this.printLine();
        this.printIndent();
        System.out.println(output);
        printLine();
    }

    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void printIndent() {
        int space = 5;
        System.out.printf("%" + space + "s", "");
    }

    public void printIndented(String output) {
        int space = 5;
        System.out.printf("%" + space + "s", "");
        System.out.println(output);
    }
}