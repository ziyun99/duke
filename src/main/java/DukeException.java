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
        EVENT_FORMAT;
    }
    private String errMsg;

    protected final String unknownErrMsg = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
    protected final String inputEmptyErrMsg = "☹ OOPS!!! Input cannot be empty";
    protected final String listEmptyErrMsg = "☹ OOPS!!! Your list is empty now.";
    protected final String doneEmptyErrMsg = "☹ OOPS!!! Index for done cannot be empty.";
    protected final String intExpectedErrMsg = "☹ OOPS!!! Index for done should be an integer.";
    protected final String indexOutOfBoundErrMsg = "☹ OOPS!!! Index out of bound.";
    protected final String todoEmptyErrMsg = "☹ OOPS!!! Todo cannot be empty";
    protected final String deadlineEmptyErrMsg = "☹ OOPS!!! Deadline cannot be empty.";
    protected final String deadlineFormatErrMsg = "☹ OOPS!!! Deadline format incorrect.";
    protected final String eventEmptyErrMsg = "☹ OOPS!!! Event cannot be empty";
    protected final String eventFormatErrMsg = "☹ OOPS!!! Event format incorrect.";


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

        }
    }

    @Override
    public String toString() {
        return this.errMsg;
    }
}
