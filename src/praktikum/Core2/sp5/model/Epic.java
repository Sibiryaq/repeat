package praktikum.Core2.sp5.model;

import java.util.ArrayList;

public class Epic extends Task {
    private final ArrayList<Integer> subtaskIdList;

    public Epic(String title, String description) {
        super(title, description);
        subtaskIdList = new ArrayList<>();
    }

    public ArrayList<Integer> getSubtaskIdList() {
        return subtaskIdList;
    }

    @Override
    public String toString() {
        return "ID задачи Epic=\"" + id
                + "\", Название задачи=\"" + name
                + "\", Описание=\"" + description
                + "\", ID сабтасок=\"" + subtaskIdList
                + "\", Статус=\"" + taskStatus + "\"";
    }

}
