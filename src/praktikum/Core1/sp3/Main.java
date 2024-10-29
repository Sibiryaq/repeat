package praktikum.Core1.sp3;

import praktikum.Core1.sp3.model.Epic;
import praktikum.Core1.sp3.model.Subtask;
import praktikum.Core1.sp3.model.Task;
import praktikum.Core1.sp3.service.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Task task;
        Subtask subtask;
        Epic epic;

        tm.createTask(new Task("Название", "Описание"));
        System.out.println("Cписок созданных задач: " + tm.getTasks());
        task = new Task("Новая задача", "с id-2");
        tm.createTask(task);
        System.out.println(task);

        epic = new Epic("Название", "Описание эпика с подзадачей");
        tm.createEpic(epic);
        subtask = new Subtask("Название подзадачи", "Описание подзадачи", epic);
        tm.createSubtask(subtask);
        System.out.println(tm.getEpics());
        System.out.println(tm.getSubtasks());

    }
}
