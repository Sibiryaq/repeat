package ivanov.service;

import ivanov.model.Task;
import java.util.List;

public interface HistoryManager {
    void add(Task task);

    List<Task> getAll();

    void remove(int id);

}
