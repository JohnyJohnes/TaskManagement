import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskParser {

    public static TaskList taskJSONParser(JSONObject jsonObject){
        TaskList taskList = new TaskList();
        JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");
        for (Object jsonTask : jsonArray){
            try {
                Task task = new Task(
                        ((JSONObject) jsonTask)
                                .getString("name"),
                        ((JSONObject) jsonTask)
                                .getString("type"),
                        new SimpleDateFormat("dd-M-yyyy hh:mm:ss").
                                parse(
                                        ((JSONObject) jsonTask)
                                                .getString("deadline")));

                taskList.addTask(task);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return taskList;
    }

}
