import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TaskParser {

    public static ArrayList<Task> taskJSONParser(JSONObject jsonObject){
        ArrayList<Task> taskList = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");
        for (Object jsonTask : jsonArray){
            try {
                Task task = new Task(
                        ((JSONObject) jsonTask)
                                .getString("name"),
                        ((JSONObject) jsonTask)
                                .getString("type"),
                        new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy").
                                parse(
                                        ((JSONObject) jsonTask)
                                                .getString("deadline")));

                taskList.add(task);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return taskList;
    }

}
