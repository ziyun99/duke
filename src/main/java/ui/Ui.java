package ui;

import exception.DukeException;

import java.util.Scanner;

/**
 * User interface code which interacts with user. Responsible for every user input and output printing except
 * for those exception handling.
 */
public class Ui {

    /**
     * Constructor for class Ui.
     */
    public Ui() {
    }

    /**
     * Shows greeting message at the start of program.
     */
    public void printHello() {
        printLine();
        printIndented("Hello! I'm Duke");
        printIndented("What can I do for you?");
        printLine();
        System.out.println("");
    }

    /**
     * Shows goodbye message at the end of program.
     */
    public void printBye() {
        print("Bye. Hope to see you again soon!");
    }

    /**
     * Shows loading error message if unable to laod data from hard disk at the start of the program.
     */
    public void showLoadingError() {
        System.out.println("Loading error occurred!");
    }

    /**
     * Read user input from the terminal.
     */
    public String readInput() {
        Scanner scan = new Scanner(System.in);
        String inData = scan.nextLine().strip();
        return inData;
    }

    /**
     * Print Duke Exception error.
     */
    public void printError(DukeException e) {
        System.out.println(e);
    }

    /**
     * Print string message in a particular output format with top and bottom horizontal line.
     */
    public void print(String output) {
        this.printLine();
        this.printIndented(output);
        printLine();
    }

    /**
     * Print horizontal line as an output format.
     */
    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Print indented message as an output format.
     */
    public void printIndented(String output) {
        int space = 5;
        System.out.printf("%" + space + "s", "");
        System.out.println(output);
    }
}
