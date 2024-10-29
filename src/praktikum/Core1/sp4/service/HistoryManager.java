package praktikum.Core1.sp4.service;

import praktikum.Core1.sp4.model.Task;
import java.util.List;

public interface HistoryManager {
    void printHistory();
    List<Task> getHistory();
    void addToHistory(Task task);

}
