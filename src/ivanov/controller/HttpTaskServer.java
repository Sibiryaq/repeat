package ivanov.controller;

import com.google.gson.reflect.TypeToken;
import ivanov.model.Epic;
import ivanov.model.Status;
import ivanov.model.Task;
import ivanov.service.Managers;
import ivanov.service.TaskManager;
import com.google.gson.Gson;

import java.time.Instant;
import java.util.HashMap;

public class HttpTaskServer {
    TaskManager taskManager;

    public HttpTaskServer() {
        this.taskManager = Managers.getDefaultTaskManager();
    }

    public HttpTaskServer(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public static void main(String[] args) {
        final Gson gson = Managers.getGson();
        Task task = new Task(1, "Тест", Status.NEW, "Описание", Instant.now(), 20);
        final HashMap<Integer, Task> map = new HashMap<>();
        map.put(task.getId(), task);


        Epic epic = new Epic(2, "Эпик", "Описание", Instant.now());
        epic.setId(2);
        epic.setStartTime(Instant.now());
        map.put(epic.getId(), epic);

        System.out.println(gson.toJson(task));
        final String json = gson.toJson(map);
        System.out.println(json);
        final HashMap<Integer, Task> mapRestored = gson.fromJson(json,
                new TypeToken<HashMap<Integer, Task>>() {
                }.getType());
        System.out.println("Restored:");
        System.out.println(mapRestored);
        System.out.println(mapRestored.get(1));

        System.out.println("Было:");
        System.out.println(map.get(2));
        System.out.println("Стало:");
        System.out.println(mapRestored.get(2));

    }
}
