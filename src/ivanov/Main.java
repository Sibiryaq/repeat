package ivanov;

import ivanov.model.Task;
import ivanov.service.*;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefaultTaskManager();
        Task task = taskManager.createTask(new Task("Новая задача"));
        System.out.println("Create task: " + task);

        Task taskFromManager = taskManager.getTaskById(task.getId());
        System.out.println("Get task: " + taskFromManager);

        taskFromManager.setName("New name");
        taskManager.updateTask(taskFromManager);
        System.out.println("Update task: " + taskFromManager);

        Task task2 = taskManager.createTask(new Task("Новая задача"));

        System.out.println("\n Cозданные Эпики : \n" + taskManager.getAllEpics());
        System.out.println("\n Созданные Задачи : \n" + taskManager.getAllTasks());
        System.out.println("\n Созданные Подзадачи : \n" + taskManager.getAllSubtasks());

        System.out.println("Показать историю : \n" + taskManager.getHistory());
        System.out.println("\nЗапрос рандомной задачи : \n" + taskManager.getTaskById(2));
        System.out.println("Показать историю : \n" + taskManager.getHistory());

    }
}

