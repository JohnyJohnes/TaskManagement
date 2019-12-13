import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        TaskList taskList = new TaskList();
        try {
            taskList.addTask(new Task("test", TaskType.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
            taskList.addTask(new Task("test1", TaskType.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
            taskList.addTask(new Task("test2", TaskType.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskList.printAllTasks();
        try {
            taskList.removeTask(new Task("test2", TaskType.SHORT, new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
                    .parse("31-08-1982 10:20:56")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskList.printAllTasks();

        ImporterToFile.saveToJson(taskList.getTaskArrayList());

        System.out.println();
        try {
            System.out.println(FileReader.readFileToString("TasksManagement/outputFiles/test.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        taskList = new TaskList();
        System.out.println("\n\n\n\n");
        taskList.printAllTasks();
        ArrayList test = new ArrayList();
        try {
            test = TaskParser.taskJSONParser(FileReader.readFileToJSON("TasksManagement/outputFiles/test.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        taskList.setTaskArrayList(test);
        System.out.println("\n\n\n\n");
        taskList.printAllTasks();

    }
}
