package ivanov.service;

import ivanov.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    ArrayList<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        if (history.size() > 9) {
            history.removeFirst();
        }
        history.add(task);
    }

    @Override
    public List<Task> getAll() {
        return null;
    }
}
