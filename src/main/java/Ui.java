import java.util.ArrayList;
import java.util.Scanner;

public class Ui {


    public Ui () {

    }

    public void printHello() {
        printLine();
        printIndented("Hello! I'm Duke");
        printIndented("What can I do for you?");
        printLine();
        System.out.println("");
    }

    public void printBye() {
        print("Bye. Hope to see you again soon!");
    }

    public void showLoadingError() {
        System.out.println("Loading error occurred!");
    }

    public String readInput() {

        Scanner scan = new Scanner(System.in);
        String inData = scan.nextLine().strip();
        return inData;
    }

    public void printError(DukeException e) {
        System.out.println(e);
    }

    public void print(String output) {
        this.printLine();
        this.printIndented(output);
        printLine();
    }

    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void printIndented(String output) {
        int space = 5;
        System.out.printf("%" + space + "s", "");
        System.out.println(output);
    }
}
