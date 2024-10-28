package praktikum.sp4.service;

import praktikum.sp4.model.Task;
import java.util.List;

public interface HistoryManager {
    void printHistory();
    List<Task> getHistory();
    void addToHistory(Task task);

}
