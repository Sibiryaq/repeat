package ivanov.service;

import ivanov.model.Epic;
import ivanov.model.Subtask;
import ivanov.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
    int sequenceId;
    HashMap<Integer, Task> tasks;
    HashMap<Integer, Epic> epics;
    HashMap<Integer, Subtask> subtasks;

    public TaskManager() {
        this.sequenceId = 0;
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subtasks = new HashMap<>();
    }

    public Task createTask(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    public Subtask createSubtask(Subtask subtask) {
        subtask.setId(generateId());
        subtasks.put(subtask.getId(), subtask);
        return subtask;
    }

    public Epic createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
        return epic;
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Task getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public Task getEpicById(int id) {
        return epics.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Subtask> getAllSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public List<Task> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        Task saved = epics.get(epic.getId());
        saved.setName(epic.getName());
        saved.setId(epic.getId());
        saved.setDescription(epic.getDescription());
    }

    public void updateSubtask(Subtask subtask) {
//        Epic epic = subtask.getEpic();
//        Epic savedEpic = epics.get(epic.getId());
//        calculateEpicStatus(savedEpic);
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void deleteSubtaskById(int id) {
        Subtask removeSubtask = subtasks.remove(id);

        Epic epic = removeSubtask.getEpic();
        Epic epicSaved = epics.get(epic.getId());

        epicSaved.getSubtasks().remove(removeSubtask);
        calculateEpicStatus(epicSaved);
    }

    public void deleteEpicById(int id) {
//        for (Task epic: epics.values()) {
//            epic.getSubtask
//        }
        tasks.remove(id);
    }

    private int generateId() {
        return ++sequenceId;
    }

    private void calculateEpicStatus(Epic epic) {
    }
}
