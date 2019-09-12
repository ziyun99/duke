package parser;

import command.ByeCommand;
import command.Command;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.DoneCommand;
import command.EventCommand;
import command.FindCommand;
import command.ListCommand;
import command.TodoCommand;
import exception.DukeException;

/**
 * Parser class parse the user input command and determine which type of command should be executed later.
 */
public class Parser {

    /**
     * Parser class Constructor.
     */
    public Parser() {
    }

    /**
     * This function takes in the users input string and parse it, then return the respective Command object.
     *
     * @param inData the user's input string/
     * @return Command object to be executed later.
     * @throws DukeException is thrown if the user input is empty or unknown.
     */
    public Command handleCommand(String inData) throws DukeException {
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


