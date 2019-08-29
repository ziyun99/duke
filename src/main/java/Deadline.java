public class Deadline extends Task {

    protected String taskLetter = "D";
    protected String by;
    private DateTimeParser dateTime;

    public Deadline(String description) {
        super("D", description, null);
    }

    public Deadline(String description, String by) {
        super("D", description, by);
        this.by = by;
        dateTime = new DateTimeParser(by);
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy () {
        return by;
    }

    @Override
    public String toString() {
        return "[" + taskLetter + "]["+ getStatusIcon() +"] " + description + " (by: " + by + ")";
    }
}