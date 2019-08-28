import javafx.event.Event;

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
            inData = scan.nextLine();
            if(!inData.equals("bye")) {
                duke.handleCommand(inData);
            } else {
                duke.bye();
                break;
            }
            System.out.println("");
        }
    }

    public Duke() {
        this.myTasks = new ArrayList<Todo>();
    }

    public void handleCommand(String inData) {
        String[] split = inData.split(" ");
        if (inData.equals("")) {
            this.print("Input is empty.");
        } else if (inData.equals("list")) {
            this.listTask();
        } else if (split[0].equals("done")) {
            this.doneTask(Integer.parseInt(split[1]));
        } else if (split[0].equals("todo")) {
            this.addTodo(inData.substring(5));
        } else if (split[0].equals("deadline")) {
            this.addDeadline(inData.substring(9));
        } else if (split[0].equals("event")) {
            this.addEvent(inData.substring(6));
        }
    }

    public void addTodo(String task) {
        Todo newTask = new Todo(task);
        myTasks.add(newTask);

        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }

    public void addDeadline(String task) {
        String[] split = task.split("/");
        String by = split[1].substring(3);
        Todo newTask = new Deadline(split[0], by);
        myTasks.add(newTask);
        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }

    public void addEvent(String task) {
        String[] split = task.split("/");
        String at = split[1].substring(3);
        Todo newTask = new Events(split[0], at);
        myTasks.add(newTask);
        printLine();
        printIndented("Got it. I've added this task: ");
        printIndented("  " + newTask.toString());
        printIndented("Now you have " + myTasks.size() + " tasks in the list.");
        printLine();
    }


    public void doneTask(int index) {
        if (index > 0 && index <= myTasks.size()) {
            Todo doneTask = myTasks.get(index - 1);
            doneTask.setDone();
            printLine();
            printIndented("Nice! I've marked this task as done: ");
            printIndented(doneTask.toString());
            printLine();
        } else {
            this.print("Alert: Index out of range.");
        }
    }

    public void listTask() {
        int i = 0;
        printLine();
        if (myTasks.size() == 0) {
            printIndent();
            System.out.println("Your list is empty now.");
        } else {
            printIndented("Here are the tasks in your list: ");
            for (Task task : myTasks) {
                i++;
                printIndented(i + "." + task.toString());
            }
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