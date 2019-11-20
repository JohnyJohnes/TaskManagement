import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TaskList {
    private ArrayList<Task> taskArrayList = new ArrayList<>();


    public HashMap<Type,ArrayList<Task>> sortTasksByType(){

        HashMap<Type,ArrayList<Task>> sortedTasks = new HashMap<>();

        ArrayList<Task> shortTaskArrayList = new ArrayList<>();
        ArrayList<Task> longTaskArrayList = new ArrayList<>();
        ArrayList<Task> delayedTaskArrayList = new ArrayList<>();
        ArrayList<Task> irrelevantTaskArrayList = new ArrayList<>();
        ArrayList<Task> doneTaskArrayList = new ArrayList<>();

        for (Task task:taskArrayList) {
            switch (task.getType()){
                case SHORT:
                    shortTaskArrayList.add(task);
                    break;
                case LONG:
                    longTaskArrayList.add(task);
                    break;
                case DELAYED:
                    delayedTaskArrayList.add(task);
                    break;
                case IRRELEVANT:
                    irrelevantTaskArrayList.add(task);
                    break;
                case DONE:
                    doneTaskArrayList.add(task);
                    break;
            }
        }

        sortedTasks.put(Type.SHORT,shortTaskArrayList);
        sortedTasks.put(Type.LONG,longTaskArrayList);
        sortedTasks.put(Type.DELAYED,delayedTaskArrayList);
        sortedTasks.put(Type.IRRELEVANT,irrelevantTaskArrayList);
        sortedTasks.put(Type.DONE,doneTaskArrayList);

        return sortedTasks;
    }

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
