public class Events extends Todo {

    protected String taskType = "E";
    protected String at;

    public Events(String description, String at) {
        super(description);
        this.at = at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getAt () {
        return at;
    }

    @Override
    public String toString() {
        return "[" + taskType + "]["+ getStatusIcon() +"] " + description + "(at: " + at + ")";
    }
}