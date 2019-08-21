import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        printLine();
        printIndent();
        System.out.println("Hello! I'm Duke");
        printIndent();
        System.out.println("What can I do for you?");
        printLine();
        System.out.println("");

        String inData;
        Scanner scan = new Scanner( System.in );
        inData = scan.nextLine();
        while (!inData.equals("bye")) {
            printLine();
            printIndent();
            System.out.println(inData);
            printLine();
            System.out.println("");
            inData = scan.nextLine();
        }
        printLine();
        printIndent();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public static void printLine() {
        printIndent();
        System.out.println("____________________________________________________________");
    }

    public static void printIndent() {
        int space = 4;
        System.out.printf("%" + space + "s" , "");
    }
}
