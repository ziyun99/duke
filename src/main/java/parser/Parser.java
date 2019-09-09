package parser;

import command.*;
import exception.DukeException;

public class Parser {

    public Parser() {
    }

    public Command handleCommand(String inData) throws DukeException {
//        this.tasks = tasks;
        String[] split = inData.split(" ");
        if (split.length == 0 || inData.equals("")) {
            throw new DukeException(DukeException.dukeExceptionType.INPUT_EMPTY);
        }
        switch (split[0]) {
            case "list":
                return new ListCommand(inData);
            case "done":
                return new DoneCommand(inData);
            case "todo":
                return new TodoCommand(inData);
            case "deadline":
                return new DeadlineCommand(inData);
            case "event":
                return new EventCommand(inData);
            case "delete":
                return new DeleteCommand(inData);
            case "find":
                return new FindCommand(inData);
            case "bye":
                return new ByeCommand(inData);
            default:
                throw new DukeException(DukeException.dukeExceptionType.UNKNOWN);
                //return new UnknownCommand();
        }
    }
}


