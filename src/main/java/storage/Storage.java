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

/**
 * Storage class contains the helper functions that is used to interact with the user's hard disk data
 * storage.
 */
public class Storage {

    private File myFile;
    private String filepath; //"C:\\WSL\\CS2113T\\duke\\data\\duke.txt";

    /**
     * Storage class Constructor.
     * @param filepath the file location in local hard disk.
     */
    public Storage(String filepath) {
        this.filepath = filepath;
    }

    /**
     * This function read the data previously stored in hard disk and reconstruct them into array list of
     * tasks.
     *
     * @return An array list of tasks, which will be passed into TaskList.
     * @throws FileNotFoundException if the file of the specified file path is not found.
     * @see TaskList
     * @see Task
     */
    public ArrayList<Task> load() throws FileNotFoundException {
        ArrayList<Task> myTasks = new ArrayList<Task>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File(this.filepath));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        while (scan.hasNext()) {
            myTasks.add(fileStrToTask(scan.nextLine()));
        }
        return myTasks;
    }

    /**
     * This function clear the content in the file, and write the TaskList into that file, save it so that
     * the user can load the data next time when starting the program.
     * This function is called when the user is exiting the program.
     *
     * @param tasks the TaskList to be saved
     */
    public void saveData(TaskList tasks) {
        try {
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


    /**
     * This function converts the format of each Task object in the TaskList into string with a particular
     * format to be written and save into local file.
     *
     * @param task Task object to be converted into string format.
     * @return a string of the task to be saved.
     */
    private String taskToFileStr(Task task) {
        String str = "";
        str += task.getTaskLetter() + " | ";
        //System.out.println(str);
        str += (task.isDone() ? "1" : "0") + " | ";
        //System.out.println(str);
        str += task.getDescription();
        //System.out.println(str);
        if (task.getTaskLetter().equals("D")) {
            str += " | " + ((Deadline) task).getBy();
            //System.out.println(str);
        } else if (task.getTaskLetter().equals("E")) {
            str += " | " + ((Events) task).getAt();
            //System.out.println(str);
        }
        //System.out.println(str);
        return str + "\n";
    }

    /**
     * This function converts the sting from local file into Task object.
     *
     * @param inData the string to be converted to Task object.
     * @return Task object converted from the string in local file.
     */
    public Task fileStrToTask(String inData) {
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
        if (split.length > 1 && split[1].equals("1")) {
            task.setDone();
        }
        return task;
    }
}