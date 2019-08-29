import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    private ArrayList<Todo> myTasks;

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

    public Duke() {
        this.myTasks = new ArrayList<Todo>();
    }

    public void handleCommand(String inData) throws DukeException {

            String[] split = inData.split(" ");
            if (split.length == 0 || inData.equals("")) {
                //this.print("Input is empty.");
                throw new DukeException(DukeException.dukeExceptionType.INPUT_EMPTY);
            } else if (inData.equals("list")) {
                this.listTask();
            } else if (split[0].equals("done")) {
                this.doneTask(inData);
                //this.doneTask(Integer.parseInt(split[1]));
            } else if (split[0].equals("todo")) {
                this.addTodo(inData);
                //this.addTodo(inData.substring(5));
            } else if (split[0].equals("deadline")) {
                this.addDeadline(inData);
                //this.addDeadline(inData.substring(9));
            } else if (split[0].equals("event")) {
                this.addEvent(inData);
                //this.addEvent(inData.substring(6));
            } else {
                throw new DukeException(DukeException.dukeExceptionType.UNKNOWN);
            }
    }

    public void addTodo(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {
            //this.print("☹ OOPS!!! The description of a todo cannot be empty.");
            throw new DukeException(DukeException.dukeExceptionType.TODO_EMPTY);
        }

        String task = split[1];
        Todo newTask = new Todo(task);
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
        String task = splitBy[0];
        String by = splitBy[1];
        Todo newTask = new Deadline(task, by);
        myTasks.add(newTask);

        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }

    public void addEvent(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {
            //this.print("☹ OOPS!!! The description of a event cannot be empty.");
            throw new DukeException(DukeException.dukeExceptionType.EVENT_EMPTY);
        }

        String[] splitAt = inData.substring(6).split(" /at ");
        if(splitAt.length == 1) {
            //this.print("☹ OOPS!!! Incorrect format for event.");
            throw new DukeException(DukeException.dukeExceptionType.EVENT_FORMAT);
        }
        String task = splitAt[0];
        String at = splitAt[1];
        Todo newTask = new Events(task, at);
        myTasks.add(newTask);

        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }


    public void doneTask(String inData)  throws DukeException{
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
            Todo doneTask = myTasks.get(index - 1);
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