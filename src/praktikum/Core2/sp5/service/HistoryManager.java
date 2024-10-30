package praktikum.Core2.sp5.service;

import praktikum.Core2.sp5.model.Task;

import java.util.List;

public interface HistoryManager {
    void addToHistory(Task task);

    void remove(int id);

    List<Task> getHistory();

}