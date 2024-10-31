package praktikum.sp6.managers;

import praktikum.sp6.tasks.Task;

import java.util.List;

public interface HistoryManager {
    void add(Task task);

    void remove(int id);

    List<Task> getTasks();
}
