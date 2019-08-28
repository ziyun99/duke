public class Task {

    protected String description;
    //private boolean isDone;

    public Task(String description) {
        this.description = description;
        //this.isDone = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void printIndent() {
        int space = 5;
        System.out.printf("%" + space + "s", "");
    }
}