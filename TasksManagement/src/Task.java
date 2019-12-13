import org.json.JSONObject;

import java.util.Date;

enum TaskType {
    SHORT, LONG, DELAYED, IRRELEVANT, DONE
}

public class Task {
    private String name;
    private TaskType taskType;
    private Date dueDate;
    private boolean isDone = false;
//    private Duration tillDueDate;

    public Task(String name, TaskType taskType, Date dueDate) {
        this.name = name;
        this.taskType = taskType;
        this.dueDate = dueDate;
//        this.tillDueDate.ofSeconds()//(dueDate.getTime()-System.currentTimeMillis())/100);
//        this.tillDueDate = Duration.between(LocalTime.now(),LocalTime);
    }

    public Task(String name, String type, Date dueDate) {
        this.name = name;
        this.taskType = stringToType(type);
        this.dueDate = dueDate;
//        this.tillDueDate.ofSeconds()//(dueDate.getTime()-System.currentTimeMillis())/100);
//        this.tillDueDate = Duration.between(LocalTime.now(),LocalTime);
    }

    public TaskType stringToType(String type){
        switch (type){
            case "SHORT":
                return TaskType.SHORT;

            case "LONG":
                return TaskType.LONG;

            case "DELAYED":
                return TaskType.DELAYED;

            case "IRRELEVANT":
                return TaskType.IRRELEVANT;

            case "DONE":
                return TaskType.DONE;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("type", taskType);
        jsonObject.put("deadline",dueDate);
        jsonObject.put("state",isDone);
        return jsonObject;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", taskType=" + taskType +
                ", dueDate=" + dueDate +
                ", isDone=" + isDone +
                '}';
    }
}
