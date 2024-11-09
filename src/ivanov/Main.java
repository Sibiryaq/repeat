package ivanov;

import ivanov.model.Task;
import ivanov.service.*;

import java.util.Comparator;

public class Main {
    static class TaskComparatorById implements Comparator<Task> {
        @Override
        public int compare(Task a, Task b) {
            return a.getId() - b.getId();
        }
    }
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefaultTaskManager();
        Task task = taskManager.createTask(new Task("Новая задача"));
        System.out.println("Create task: " + task);

        Task taskFromManager = taskManager.getTaskById(task.getId());
        System.out.println("Get task: " + taskFromManager);

        taskFromManager.setName("New name");
        taskManager.updateTask(taskFromManager);
        System.out.println("Update task: " + taskFromManager);

        taskManager.deleteTaskById(taskFromManager.getId());
        System.out.println("Delete task: " + task);
    }
}

