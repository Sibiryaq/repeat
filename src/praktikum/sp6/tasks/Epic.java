package praktikum.sp6.tasks;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subTasksId;

    public Epic(String name, String description) {
        super(name, description);
        this.status = Status.NEW;
        this.subTasksId = new ArrayList<>();
    }

    public void addSubTask(SubTask subTask) {
        subTasksId.add(subTask.getId());
    }

    @Override
    public String toString() {
        return "Epics{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", subTasksId=" + subTasksId +
                '}';
    }

    public List<Integer> getSubTasksId() {
        return subTasksId;
    }
}
