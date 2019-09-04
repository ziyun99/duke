package command;

import ui.Ui;

public abstract class Command {

    protected String inData;
    protected boolean isExit;

    public Command (String inData) {
        this.inData = inData;
        isExit = false;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public boolean isExit () {
        return isExit;
    }

}
