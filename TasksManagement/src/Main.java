import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args){
        TaskList taskList = new TaskList();
        try {
            taskList.addTask(new Task("test", Type.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
            taskList.addTask(new Task("test1", Type.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
            taskList.addTask(new Task("test2", Type.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskList.printAllTasks();
        try {
            taskList.removeTask(new Task("test2", Type.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskList.printAllTasks();

        ImporterToFile.saveToTxt(taskList.getTaskArrayList());

        System.out.println();
        try {
            System.out.println(FileReader.readFileAsString("TasksManagement/outputFiles/test.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
