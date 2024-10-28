package praktikum.sp4.service;
import praktikum.sp4.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private static final List<Task> history = new ArrayList<>();

    @Override
    public void printHistory() {
        for (Task task : getHistory()) {
            System.out.println(task);
        }
    }

    @Override
    public List<Task> getHistory() {
        return history;
    }

    @Override
    public void addToHistory(Task task) {
        if (task != null) {
            history.add(task);
            if (history.size() > 10) {
                history.removeFirst();
            }
        }
    }
}