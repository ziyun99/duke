package task;

public class Task {

    protected String taskLetter ;
    protected String description;
    protected String time;
    protected boolean isDone;


    public Task() {
        //this.description = "";
        this.isDone = false;
    }

    public Task(String taskLetter, String description, String time) {
        this.taskLetter = taskLetter;
        this.description = description;
        this.isDone = false;
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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