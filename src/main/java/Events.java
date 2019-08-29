public class Events extends Task {

    protected String taskLetter = "E";
    protected String at;

    public Events(String description, String at) {
        super("E", description, at);
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
        return "[" + taskLetter + "]["+ getStatusIcon() +"] " + description + " (at: " + at + ")";
    }
}