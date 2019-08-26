
public class Task {

    private String taskName;
    private boolean isDone;
    //private String status;

    public Task(String task) {
        this.taskName = task;
        this.isDone = false;
    }

    public void setName(String task) {
        this.taskName = task;
    }

    public void setDone() {
        this.isDone = true;
        printLine();
        printIndent();
        System.out.println("Nice! I've marked this task as done: ");
        printIndent();
        System.out.println("  [/] "+ this.taskName);
        printLine();
    }

    public String getName() {
        return taskName;
    }

    public boolean getStatus() {
        return isDone;
    }

    public String getStatusIcon() {
        return isDone? "/" : "x";
    }

    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void printIndent() {
        int space = 5;
        System.out.printf("%" + space + "s", "");
    }
}