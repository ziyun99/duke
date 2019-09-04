package task;

import task.Task;

public class Todo extends Task {

    protected String taskLetter = "T";
    protected boolean isDone;

    public Todo(String description) {
        super("T", description, null);
    }

    public void setDone() {
        this.isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getStatusIcon() {
        return isDone ? "/" : "x";
    }

    @Override
    public String toString() {
        return "[" + taskLetter + "][" + getStatusIcon() + "] " + description;
    }
}
