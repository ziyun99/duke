import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    private ArrayList<Task> myTasks;

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
        this.myTasks = new ArrayList<Task>();
    }

    public void handleCommand(String inData) {
        String[] split = inData.split(" ");
        if (inData.equals("")) {
            this.print("Input is empty.");
        } else if (inData.equals("list")) {
            this.listTask();
        } else if (split.length == 2 && split[0].equals("done")) {
            this.doneTask(Integer.parseInt(split[1]));
        } else {
            this.addTask(inData);
        }
    }

    public void addTask(String task) {
        Task newTask = new Task(task);
        myTasks.add(newTask);
        printLine();
        printIndent();
        System.out.println("added: " + task);
        printLine();
    }

    public void doneTask(int index) {
        if (index > 0 && index <= myTasks.size()) {
            Task doneTask = myTasks.get(index - 1);
            doneTask.setDone();
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
            printIndent();
            System.out.println("Here are the tasks in your list: ");
            for (Task task : myTasks) {
                printIndent();
                i++;
                System.out.println(i + ".[" + task.getStatusIcon() + "] " + task.getName());
            }
        }
        printLine();
    }

    public void hello() {
        printLine();
        printIndent();
        System.out.println("Hello! I'm Duke");
        printIndent();
        System.out.println("What can I do for you?");
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
}