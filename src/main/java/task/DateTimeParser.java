package task;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * DateTimeParser Class parses the date or time.
 */
public class DateTimeParser {

    private Date date;
    private SimpleDateFormat dateFormat;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;

    /**
     * DateTimeParser Class Constructor
     *
     * @param inDate the datetime input by the user.
     */
    public DateTimeParser(String inDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            this.date = dateFormat.parse(inDate);
            //System.out.println("task.Deadline recorded: " + date.toString());
        } catch (ParseException e) {
            System.out.println(e);
            System.out.println(" The date & time format should be in <dd/mm/yyyy HHmm>");
        }
    }

    /**
     * Get the formatted string of the datetime.
     *
     * @return the formatted string of the datetime.
     */
    public String toString() {
        return date.toString();
        //return this.dateFormat.format(this.date);
    }
}