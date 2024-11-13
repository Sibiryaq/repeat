package ivanov.model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    List<Subtask> subtasks = new ArrayList<>();

    public Epic(String name) {
        super(name);
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
                ", name='" + getName() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", startTime=" + getStartTime() + '\'' +
                ", duration=" + getDuration() + '\'' +
                ", endTime=" + getEndTime() +
                ", subtasks ID: [" + getSubtasks() +
                "]}";
    }
}
