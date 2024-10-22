package praktikum.sp3.service;

import praktikum.sp3.Status;
import praktikum.sp3.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TaskManager {
    private int sequenceId = 0;
    private final HashMap<Integer, Task> tasks;
    private final HashMap<Integer, Subtask> subtasks;
    private final HashMap<Integer, Epic> epics;

    public TaskManager() {
        tasks = new HashMap<>();
        subtasks = new HashMap<>();
        epics = new HashMap<>();
    }

    public void createTask(Task task) {
        task.setId(++sequenceId);
        tasks.put(task.getId(), task);
    }

    public void createSubtask(Subtask subtask) {
        subtask.setId(++sequenceId);
        subtasks.put(subtask.getId(), subtask);
        epics.put(subtask.getEpic().getId(), subtask.getEpic());
    }

    public void createEpic(Epic epic) {
        epic.setId(++sequenceId);
        epics.put(epic.getId(), epic);
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Subtask getSubtask(int id) {
        return subtasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public List<Task> getTasks(){
        return new ArrayList<>(tasks.values());
    }

    public List<Subtask> getSubtasks(){
        return new ArrayList<>(subtasks.values());
    }

    public List<Epic> getEpics(){
        return new ArrayList<>(epics.values());
    }

    public void deleteTasks() {
        tasks.clear();
    }

    public void deleteSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.getSubTasks().clear();
            updateStatusEpic(epic);
        }
    }

    public void deleteEpics() {
        epics.clear();
        subtasks.clear();
    }

    public void deleteTask(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            System.out.println("Задача с id# " + id + " удалена." + System.lineSeparator());
        }
    }

    public void deleteSubtask(int id) {
        if (subtasks.containsKey(id)) {
            subtasks.remove(id);
            System.out.println("Подзадача с id# " + id + " удалена." + System.lineSeparator());
            updateStatusEpic(subtasks.get(id).getEpic());
        }
    }

    public void deleteEpic(int id) {
        if (epics.containsKey(id)) {
            epics.remove(id);
            System.out.println("Эпик с id# " + id + " удален." + System.lineSeparator());
        }
    }

    private boolean checkStatus(String status, Epic epic) {
        for (Subtask subtask : epic.getSubTasks()) {
            if (!Objects.equals(subtasks.get(subtask).getStatus(), status)) {
                return false;
            }
        }
        return true;
    }

    private void updateStatusEpic(Epic epic) {
        if (epic.getSubTasks().isEmpty() || checkStatus("NEW", epic)) {
            epic.setStatus(Status.NEW);

        } else if (checkStatus("DONE", epic)) {
            epic.setStatus(Status.DONE);

        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }
}
