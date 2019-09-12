package task;

import java.util.ArrayList;

/**
 * TaskList class.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * TaskList class Constructor.
    */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * TaskList class Constructor.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Get the array list of the TaskList.
     *
     * @return the array list of the TaskList.
     */
    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }

}
