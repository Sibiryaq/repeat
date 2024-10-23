package praktikum.sp3;

import praktikum.sp3.model.Epic;
import praktikum.sp3.model.Subtask;
import praktikum.sp3.model.Task;
import praktikum.sp3.service.TaskManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Task task;
        Subtask  subtask;
        Epic epic;

        tm.createTask(new Task("Название", "Описание"));
        System.out.println("Cписок созданных задач: " + tm.getTasks());




    }
}
