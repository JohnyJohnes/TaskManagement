import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortTasks {

    public static void sortByName(ArrayList<Task> tasks){
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
