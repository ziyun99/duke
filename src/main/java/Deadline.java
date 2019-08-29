public class Deadline extends Todo {

    protected String taskType = "D";
    protected String by;

    public Deadline(String description) {
        super(description);
    }

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy () {
        return by;
    }

    @Override
    public String toString() {
        return "[" + taskType + "]["+ getStatusIcon() +"] " + description + " (by: " + by + ")";
    }
}