import java.util.Scanner;

public class Duke {

    static String[][] myTasks = new String[100][2];
    static int num = 0;

    public static void main(String[] args) {

        printHello();

        String inData;
        Scanner scan = new Scanner(System.in);
        inData = scan.nextLine();
        while (!inData.equals("bye")) {
            String split[] = inData.split(" ");
            if (inData.equals("list")) {
                listTask();
            } else if (split[0].equals("done")) {
                updateTask(Integer.parseInt(split[1]));
            } else {
                addTask(inData);
                num ++;
            }
            System.out.println("");
            inData = scan.nextLine();
        }
        printBye();
    }

    public static void printHello() {
        printLine();
        printIndent();
        System.out.println("Hello! I'm Duke");
        printIndent();
        System.out.println("What can I do for you?");
        printLine();
        System.out.println("");
    }


    public static void printBye() {
        printLine();
        printIndent();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public static void printLine() {
        int space = 4;
        System.out.printf("%" + space + "s", "");
        System.out.println("____________________________________________________________");
    }

    public static void printIndent() {
        int space = 5;
        System.out.printf("%" + space + "s", "");
    }

    public static void listTask() {
        printLine();
        printIndent();
        System.out.println("Here are the tasks in your list: ");
        for (int i = 0; i < num; i++) {
            String status = "x";
            if (myTasks[i][1].equals("true")) {
                status = "/";
            }

            printIndent();
            int j = i + 1;
            System.out.println(j + ".["  + status + "] "+ myTasks[i][0]);
        }
        printLine();
    }

    public static void addTask(String task) {
        myTasks[num][0] = task;
        myTasks[num][1] = "false";
        printLine();
        printIndent();
        System.out.println("added: " + task);
        printLine();
    }

    public static void updateTask(int index) {
        myTasks[index - 1][1] = "true";

        printLine();
        printIndent();
        System.out.println("Nice! I've marked this task as done: ");
        printIndent();
        System.out.println("  [/] "+ myTasks[index - 1][0]);
        printLine();
    }

}


