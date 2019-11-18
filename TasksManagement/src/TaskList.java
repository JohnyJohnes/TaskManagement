import java.util.ArrayList;
import java.util.Date;

public class TaskList {
    private ArrayList<Task> taskArrayList = new ArrayList<>();

    public void addTask(Task task){
        taskArrayList.add(task);
        System.out.println("Added");
    }

    public void removeTask(Task task){
        
        taskArrayList.remove(task);
        System.out.println("removed");

    }

    public void printAllTasks(){
        for (Task item :
                taskArrayList) {
            System.out.println(item.toString());
        }
        System.out.println("-----End of list----");
    }

    public void changeTask(Task task, Date dueDate){
        if (taskArrayList.contains(task))
            taskArrayList.stream().filter(
                    t->(t.getDueDate().equals(dueDate)) && (t.equals(task)))
                    .findAny().get()
                    .setDueDate(dueDate);
    }


    public void changeTask(Task task, Type type){
        if (taskArrayList.contains(task))
            taskArrayList.stream().filter(
                    t->(t.getType().equals(type)) && (t.equals(task)))
                    .findAny().get()
                    .setType(type);
    }

    public void changeTask(Task task, String name){
        if (taskArrayList.contains(task))
            taskArrayList.stream().filter(
                    t-> (t.getName().equals(name)) && (t.equals(task)))
                    .findAny().get()
                    .setName(name);
    }

    public void changeTask(Task task, boolean doneState){
        if (taskArrayList.contains(task))
            taskArrayList.stream().filter(
                    t->(t.isDone() == doneState) && (t.equals(task)))
                    .findAny().get()
                    .setDone(doneState);
    }



    public int indexOfTask(Task task){
        return taskArrayList.indexOf(task);
    }

}
