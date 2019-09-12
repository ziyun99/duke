package task;

import task.Task;

/**
 * Events class is one of the type of task.
 */
public class Events extends Task {

    protected String taskLetter = "E";
    protected String at;

    /**
     * Events class Constructor.
     *
     * @param description description of the task.
     * @param at datetime of the task.
     */
    public Events(String description, String at) {
        super("E", description, at);
        this.at = at;
    }


    //public void setAt(String at) {
    //    this.at = at;
    //}

    /**
     * Get the datetime of the event.
     *
     * @return the datetime of the event.
     */
     public String getAt() {
        return at;
    }

    /**
     * Get the formatted string of the task.
     *
     * @return formatted string of the task.
     */
    @Override
    public String toString() {
        return "[" + taskLetter + "][" + getStatusIcon() + "] " + description + " (at: " + at + ")";
    }
}