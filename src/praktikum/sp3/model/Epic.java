package praktikum.sp3.model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    List<Subtask> subTasks;

    public Epic(String name, String description) {
        super(name, description);
        subTasks = new ArrayList<>();
    }

    public List<Subtask> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return "ID задачи Epic=\"" + id
                + "\", Название задачи=\"" + name
                + "\", Описание=\"" + description
                + "\", Идентификаторы подзадач в эпике=\"" + subTasks
                + "\", Статус=\"" + status + "\"";
    }
}
