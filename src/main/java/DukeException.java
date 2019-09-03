public class DukeException extends Exception{
    public enum dukeExceptionType {
        UNKNOWN,
        INPUT_EMPTY,
        LIST_EMPTY,
        DONE_EMPTY,
        INT_EXPECTED,
        INDEX_OUT_OF_BOUND,
        TODO_EMPTY,
        DEADLINE_EMPTY,
        DEADLINE_FORMAT,
        EVENT_EMPTY,
        EVENT_FORMAT,
        DELETE_EMPTY;
    }
    private String errMsg;

    protected final String unknownErrMsg = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    protected final String inputEmptyErrMsg = "☹ OOPS!!! Input cannot be empty\n";
    protected final String listEmptyErrMsg = "☹ OOPS!!! Your list is empty now.\n";
    protected final String doneEmptyErrMsg = "☹ OOPS!!! Index for done cannot be empty.\n";
    protected final String intExpectedErrMsg = "☹ OOPS!!! Index for <done> or <delete> should be an integer.\n";
    protected final String indexOutOfBoundErrMsg = "☹ OOPS!!! Index out of bound.\n";
    protected final String todoEmptyErrMsg = "☹ OOPS!!! <todo> cannot be empty.\n";
    protected final String deadlineEmptyErrMsg = "☹ OOPS!!! <deadline> cannot be empty.\n";
    protected final String deadlineFormatErrMsg = "☹ OOPS!!! <deadline> format incorrect.\n";
    protected final String eventEmptyErrMsg = "☹ OOPS!!! <event> cannot be empty.\n";
    protected final String eventFormatErrMsg = "☹ OOPS!!! <event>format incorrect.\n";
    protected final String deleteEmptyErrMsg = "? OOPS!!! <delete> cannot be empty.\n";


    public DukeException(dukeExceptionType errType) {
        this.setErrMSg(errType);
    }

    private void setErrMSg(dukeExceptionType errType) {
        switch (errType) {
            case UNKNOWN:
                this.errMsg = unknownErrMsg;
                break;
            case INPUT_EMPTY:
                this.errMsg = inputEmptyErrMsg;
                break;
            case LIST_EMPTY:
                this.errMsg = listEmptyErrMsg;
                break;
            case DONE_EMPTY:
                this.errMsg = doneEmptyErrMsg;
                break;
            case INT_EXPECTED:
                this.errMsg = intExpectedErrMsg;
                break;
            case INDEX_OUT_OF_BOUND:
                this.errMsg = indexOutOfBoundErrMsg;
                break;
            case TODO_EMPTY:
                this.errMsg = todoEmptyErrMsg;
                break;
            case DEADLINE_EMPTY:
                this.errMsg = deadlineEmptyErrMsg;
                break;
            case DEADLINE_FORMAT:
                this.errMsg = deadlineFormatErrMsg;
                break;
            case EVENT_EMPTY:
                this.errMsg = eventEmptyErrMsg;
                break;
            case EVENT_FORMAT:
                this.errMsg = eventFormatErrMsg;
                break;
            case DELETE_EMPTY:
                this.errMsg = deleteEmptyErrMsg;
                break;
        }
    }

    @Override
    public String toString() {
        return this.errMsg;
    }
}
