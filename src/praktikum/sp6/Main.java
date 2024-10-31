package praktikum.sp6;

import praktikum.sp6.managers.InMemoryTaskManager;
import praktikum.sp6.managers.TaskManager;
import praktikum.sp6.tasks.Epic;
import praktikum.sp6.tasks.SubTask;
import praktikum.sp6.tasks.Task;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InMemoryTaskManager taskManager = new InMemoryTaskManager();

        Task task1 = new Task("task 1", "Description 1");
        Task task2 = new Task("tasks.Task 2", "Description 2");
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        Epic epic1 = new Epic("epic1", "description");
        SubTask subTask1 = new SubTask("st1.1", "subtask1.1", 1);
        SubTask subTask2 = new SubTask("st1.2", "subtask1.2", 1);
        SubTask subTask3 = new SubTask("st1.3", "subtask1.3", 1);
        taskManager.addEpic(epic1);
        taskManager.addSubTask(subTask1, 3);
        taskManager.addSubTask(subTask2, 3);
        taskManager.addSubTask(subTask3, 3);


        Epic epic2 = new Epic("epic2", "description2");
        taskManager.addEpic(epic2);

        printAllTasks(taskManager);
    }

    public static void printAllTasks(TaskManager manager) {

        manager.getTask(2);
        manager.getEpic(3);


        System.out.println("История 1:");
        List<Task> history = manager.getHistory();
        for (Task task : history) {
            System.out.println(task);
        }


        manager.getEpic(7);
        manager.getSubTask(6);
        manager.getSubTask(4);
        manager.getEpic(3);
        manager.getSubTask(5);
        manager.getTask(2);
        manager.getEpic(3);
        manager.getTask(1);


        System.out.println("История после вызова повторных id:");
        var history2 = manager.getHistory();
        for (Task task : history2) {
            System.out.println(task);
        }
        manager.deleteTask(1);

        System.out.println("История после удаления задачи 1:");
        var history3 = manager.getHistory();
        for (Task task : history3) {
            System.out.println(task);
        }
        manager.deleteEpic(3);

        System.out.println("История после удаления эпика 3:");
        var history4 = manager.getHistory();
        for (Task task : history4) {
            System.out.println(task);
        }


    }
}
