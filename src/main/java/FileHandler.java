import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
//import java.util.Formatter;
import java.util.Scanner;

/*
public class FileHandler {

    public static void main(String[] args) {
        File myFile = new File("C:\\WSL\\CS2113T\\duke\\data\\duke.txt");

        if (myFile.exists()) {
            System.out.println("ok");
        } else {
            System.out.println("error");
        }
    }
}
public class FileHandler {

    public static void main(String[] args) {
        final Formatter x;

        try {
            x = new Formatter("test.txt");
            System.out.println("file created");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
*/

public class FileHandler {

    private File myFile;
    private String filepath = "C:\\WSL\\CS2113T\\duke\\data\\duke.txt";

    public FileHandler() {
        //myFile = new File("C:\\WSL\\CS2113T\\duke\\data\\duke.txt");
        //loadData();
    }

    public ArrayList<Task> loadData() throws FileNotFoundException {
        ArrayList<Task> myTasks = new ArrayList<Task>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File(this.filepath));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        while (scan.hasNext()) {
            myTasks.add(FileStrToTask(scan.nextLine()));
        }
        return myTasks;
    }

    public void saveData(ArrayList<Task> myTasks) {
        try{
            FileWriter fw = new FileWriter(filepath);
            for (Task task : myTasks) {
                fw.write(taskToFileStr(task));
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private String taskToFileStr(Task task) {
        String str = "";
        str += task.getTaskLetter() + " | ";
        //System.out.println(str);
        str += (task.isDone() ? "1" : "0") + " | ";
        //System.out.println(str);
        str += task.getDescription();
        //System.out.println(str);
        if (task.getTaskLetter().equals("D")) {
            str += " | " + ((Deadline)task).getBy();
            //System.out.println(str);
        } else if (task.getTaskLetter().equals("E")) {
            str += " | " + ((Events)task).getAt();
            //System.out.println(str);
        }
        //System.out.println(str);
        return str+"\n";
    }

    public Task FileStrToTask(String inData) {
        String[] split = inData.split("\\|");
        //strip any leading spaces
        Task task = new Task();
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].strip();
        }
        if (split[0].equals("T") && split.length == 3) {
            task = new Todo(split[2]);
        } else if (split[0].equals("D") && split.length == 4) {
            task = new Deadline(split[2], split[3]);
        } else if (split[0].equals("E") && split.length == 4) {
            task = new Events(split[2], split[3]);
        }
        if (split.length >1 && split[1].equals("1")) {
            task.setDone();
        }
        return task;
    }


}