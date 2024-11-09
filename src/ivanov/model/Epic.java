package ivanov.model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task{
    List<Subtask> subtasks = new ArrayList<>();

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public String toString() {
        return "Epic{" +
                ", name='" + getName() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", description='" + getDescription() + '\'' +
                "subtasks ID: [" + getSubtasks() +
                "]}";
    }
}
