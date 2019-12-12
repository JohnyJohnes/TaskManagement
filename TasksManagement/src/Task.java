import org.json.JSONObject;

import java.util.Date;

enum Type{
    SHORT, LONG, DELAYED, IRRELEVANT, DONE
}

public class Task {
    private String name;
    private Type type;
    private Date dueDate;
    private boolean isDone = false;
//    private Duration tillDueDate;

    public Task(String name, Type type, Date dueDate) {
        this.name = name;
        this.type = type;
        this.dueDate = dueDate;
//        this.tillDueDate.ofSeconds()//(dueDate.getTime()-System.currentTimeMillis())/100);
//        this.tillDueDate = Duration.between(LocalTime.now(),LocalTime);
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("type",type);
        jsonObject.put("deadline",dueDate);
        jsonObject.put("state",isDone);
        return jsonObject;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", dueDate=" + dueDate +
                ", isDone=" + isDone +
                '}';
    }
}
