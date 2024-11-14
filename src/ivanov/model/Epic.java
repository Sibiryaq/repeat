package ivanov.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    List<Subtask> subtasks = new ArrayList<>();

    public Epic(String name) {
        super(name);
    }

    public Epic(int id, String name, String description, Instant startTime) {
        super(id, name, description, startTime);
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public TaskType getType() {
        return TaskType.EPIC;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasks=" + subtasks +
                "} " + super.toString();
    }
}
