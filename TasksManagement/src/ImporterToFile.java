

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ImporterToFile {

    public static void saveToJson(ArrayList<Task> tasks){

        JSONObject obj = taskArrayListToJSON(tasks);

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("TasksManagement/outputFiles/test.json")) {
            file.write(obj.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToTxt(ArrayList<Task> tasks){

        JSONObject obj = taskArrayListToJSON(tasks);

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("TasksManagement/outputFiles/test.txt")) {
            file.write(obj.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToYourFile(ArrayList<Task> tasks, String filePath){
        JSONObject obj = taskArrayListToJSON(tasks);

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(obj.toString().replace("/\\/g", ""));
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject taskArrayListToJSON(ArrayList<Task> tasks){
        JSONObject obj = new JSONObject();
        JSONArray jsonArrayList = new JSONArray();
        for (Task task : tasks) {
//            JSONArray taskList = new JSONArray();
//            taskList.put("name: "+task.getName());
//            taskList.put("type: "+task.getTaskType().toString());
//            taskList.put("state: "+task.isDone());
//            taskList.put("deadline: "+task.getDueDate().toString());

            jsonArrayList.put(task.toJSON());
        }
        obj.put("tasks",jsonArrayList);
        return obj;
    }
}
