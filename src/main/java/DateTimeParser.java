import java.util.Date;
        import java.text.SimpleDateFormat;
        import java.text.ParseException;

public class DateTimeParser {

    private Date date;
    private SimpleDateFormat dateFormat;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;

    public DateTimeParser(String inDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            this.date = dateFormat.parse(inDate);
            System.out.println("Deadline recorded: " + date.toString());
        } catch (ParseException e) {
            System.out.println(e);
            System.out.println(" The date & time format should be in <dd/mm/yyyy HHmm>");
        }
    }

    public String toString() {
        return date.toString();
        //return this.dateFormat.format(this.date);
    }
}