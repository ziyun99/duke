import java.util.Scanner;

public class Duke {

    static String[] myTasks = new String[100];
    static int num = 0;

    public static void main(String[] args) {

        printHello();

        String inData;
        Scanner scan = new Scanner(System.in);
        inData = scan.nextLine();
        while (!inData.equals("bye")) {
            if (inData.equals("list")) {
                listTask();
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
        for (int i = 0; i < num; i++) {
            printIndent();
            int j = i + 1;
            System.out.println(j + ". " + myTasks[i]);
        }
        printLine();
    }

    public static void addTask(String task) {
        myTasks[num] = task;
        printLine();
        printIndent();
        System.out.println("added: " + task);
        printLine();
    }

}

