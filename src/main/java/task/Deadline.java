package task;

import task.Task;

/**
 * Deadline class is one of the type of task.
 */
public class Deadline extends Task {

    protected String taskLetter = "D";
    protected String by;
    private DateTimeParser dateTime;

    /**
     * Deadline class Constructor.
     *
     * @param description description of the task.
     */
    public Deadline(String description) {
        super("D", description, null);
    }

    /**
     * Deadline class Constructor.
     *
     * @param description description of the task.
     * @param by deadline for the task.
     */
    public Deadline(String description, String by) {
        super("D", description, by);
        this.by = by;
        dateTime = new DateTimeParser(by);
    }

    //public void setBy(String by) {
    //    this.by = by;
    //}

    /**
     * Get the deadline of the task.
     *
     * @return deadline for thr task in time String.
     */
    public String getBy() {
        return by;
    }

    /**
     * Get the formatted string of the task.
     *
     * @return formatted string of the task.
     */
    @Override
    public String toString() {
        return "[" + taskLetter + "][" + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }
}