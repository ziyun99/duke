package task;

import task.Task;

/**
 * Todo class is one of the type of task.
 */
public class Todo extends Task {

    protected String taskLetter = "T";
    protected boolean isDone;

    /**
     * Todo class Constructor.
     *
     * @param description description of the task.
     */
    public Todo(String description) {
        super("T", description, null);
    }

    /**
     * Set the task as done.
     */
    public void setDone() {
        this.isDone = true;
    }

    /**
     * Get the done status of the task.
     *
     * @return the done status of the task.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Get the status Icon of the task.
     *
     * @return the status icon of the task.
     */
    public String getStatusIcon() {
        return isDone ? "/" : "x";
    }

    /**
     * Get the formatted string of the task.
     *
     * @return formatted string of the task.
     */
    @Override
    public String toString() {
        return "[" + taskLetter + "][" + getStatusIcon() + "] " + description;
    }
}
