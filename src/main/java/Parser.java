import command.Command;
import command.TodoCommand;
import exception.DukeException;
import task.Deadline;
import task.Events;
import task.Task;

import java.util.ArrayList;

public class Parser {

    public Parser () {
    }

    public Command handleCommand(String inData) throws DukeException {
//        this.tasks = tasks;
        String[] split = inData.split(" ");
        if (split.length == 0 || inData.equals("")) {
            throw new DukeException(DukeException.dukeExceptionType.INPUT_EMPTY);
        }
        switch (split[0])  {
            case "list":
                return new ListCommand(inData);
                break;
            case "done":
                return new DoneCommand(inData);
                break;
            case "todo":
                return new TodoCommand(inData);
                break;
            case "deadline":
                return new DeadlineCommand(inData);
                break;
            case "event":
                return new EventCommand(inData);
                break;
            case "delete":
                return new DeleteCommand(inData);
                break;
            case "find":
                return new FindCommand(inData);
            break;
            case "bye":
                return new ByeCommand(inData);
                break;
            default:
                throw new DukeException(DukeException.dukeExceptionType.UNKNOWN);
                //return new UnkownCommand();
        }
    }

    public void addDeadline(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DEADLINE_EMPTY);
        }

        String[] splitBy = inData.substring(9).split(" /by ");
        if(splitBy.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DEADLINE_FORMAT);
        }
        String task = splitBy[0].strip();
        String by = splitBy[1].strip();
        Task newTask = new Deadline(task, by);
        tasks.getTaskList().add(newTask);

        ui.printLine();
        ui.printIndented("Got it. I've added this task: ");
        ui.printIndented("  " + newTask.toString());
        ui.printIndented("Now you have " + tasks.getTaskList().size() + " tasks in the list.");
        ui.printLine();
    }

    public void addEvent(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if(split.length == 1) {   }

        String[] splitAt = inData.substring(6).split(" /at ");
        if(splitAt.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.EVENT_FORMAT);
        }
        String task = splitAt[0].strip();
        String at = splitAt[1].strip();
        Task newTask = new Events(task, at);
        tasks.getTaskList().add(newTask);

        ui.printLine();
        ui.printIndented("Got it. I've added this task: ");
        ui.printIndented("  " + newTask.toString());
        ui.printIndented("Now you have " + tasks.getTaskList().size() + " tasks in the list.");
        ui.printLine();
    }

    public void deleteTask(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if (split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DELETE_EMPTY);
        }

        int index = 0;
        try {
            index = Integer.parseInt(split[1].strip());
        } catch (NumberFormatException e) {
            throw new DukeException(DukeException.dukeExceptionType.INT_EXPECTED);
        }

        if (index > 0 && index <= tasks.getTaskList().size()) {
            Task deleteTask = tasks.getTaskList().get(index - 1);
            tasks.getTaskList().remove(index - 1);
            ui.printLine();
            ui.printIndented("Noted. I've removed this task: ");
            ui.printIndented(deleteTask.toString());
            ui.printIndented("Now you have " + tasks.getTaskList().size() + " tasks in the list.");
            ui.printLine();
        } else {
            throw new DukeException(DukeException.dukeExceptionType.INDEX_OUT_OF_BOUND);
        }
    }

    public void findTask(String inData) throws DukeException {
        String[] split = inData.split(" ");

        if (split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.FIND_EMPTY);
        }

        String keyword = inData.substring(5).strip();
        ArrayList<Task> findList = new ArrayList<Task>();

        for (Task task : tasks.getTaskList()) {
            if (task.getDescription().contains(keyword)) {
                findList.add(task);
            }
        }
        ui.printLine();
        if (findList.size() == 0) {
            ui.printIndented("Result: No matching tasks in your list.");
        } else {
            ui.printIndented("Here are the matching tasks in your list:");
            int i = 0;
            for (Task task : findList) {
                i++;
                ui.printIndented(i + "." + task.toString());
            }
        }
        ui.printLine();
    }

    public void doneTask(String inData) throws DukeException{
        String[] split = inData.split(" ");

        if(split.length == 1) {
            throw new DukeException(DukeException.dukeExceptionType.DONE_EMPTY);
        }

        int index = 0;
        try {
            index = Integer.parseInt(split[1].strip());
        } catch (NumberFormatException e) {
            throw new DukeException(DukeException.dukeExceptionType.INT_EXPECTED);
        }

        if (index > 0 && index <= tasks.getTaskList().size()) {
            Task doneTask = (Task) tasks.getTaskList().get(index - 1);
            doneTask.setDone();
            ui.printLine();
            ui.printIndented("Nice! I've marked this task as done: ");
            ui.printIndented(doneTask.toString());
            ui.printLine();
        } else {
            throw new DukeException(DukeException.dukeExceptionType.INDEX_OUT_OF_BOUND);
        }
    }

    public void listTask() throws DukeException {
        int i = 0;

        if (tasks.getTaskList().size() == 0) {
            throw new DukeException(DukeException.dukeExceptionType.LIST_EMPTY);
        }

        ui.printLine();
        ui.printIndented("Here are the tasks in your list: ");
        for (Task task : tasks.getTaskList()) {
            i++;
            ui.printIndented(i + "." + task.toString());
        }
        ui.printLine();
    }
}
