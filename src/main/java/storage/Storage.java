package storage;

import task.TaskList;
import task.Deadline;
import task.Events;
import task.Task;
import task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private File myFile;
    private String filepath; //"C:\\WSL\\CS2113T\\duke\\data\\duke.txt";

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Task> load() throws FileNotFoundException {
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

    public void saveData(TaskList tasks) {
        try{
            ArrayList<Task> myTasks = tasks.getTaskList();
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