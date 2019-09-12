package task;

/**
 * Task super class of all types of tasks, with attributes and methods that all tasks share.
 */
public class Task {

    protected String taskLetter;
    protected String description;
    protected String time;
    protected boolean isDone;

    /**
     * Constructor for a task.
     */
    public Task() {
        //this.description = "";
        this.isDone = false;
    }

    /**
     * Constructor for a task.
     *
     * @param taskLetter the letter that shows the type of task.
     * @param description description of the task.
     * @param time time involved in a task.
     */
    public Task(String taskLetter, String description, String time) {
        this.taskLetter = taskLetter;
        this.description = description;
        this.isDone = false;
        this.time = time;
    }

    //public void setDescription(String description) {
    //    this.description = description;
    //}

    /**
     * Get the description of the task in string.
     *
     * @return description of the task in string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the task as done.
     */
    public void setDone() {
        this.isDone = true;
    }

    /**
     * Check if the function is done or not.
     *
     * @return the isDone status of the task.
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
     * Get the task letter of the task.
     *
     * @return the task letter of the task.
     */
    public String getTaskLetter() {
        return taskLetter;
    }

    /*
    public String toFileString() {
        String str;
        str += this.getTaskLetter() + " | ";
        str += (this.isDone() ? "1" : "0") + " | ";
        str += this.getDescription();
        for (String argStr : this.getArgStrArr()) {
            str += " | " + argStr;
        }
        return str+"\n";
        }
     */
}