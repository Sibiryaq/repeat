package ivanov.service;

import ivanov.model.Epic;
import ivanov.model.Subtask;
import ivanov.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    int sequenceId;
    HashMap<Integer, Task> tasks;
    HashMap<Integer, Epic> epics;
    HashMap<Integer, Subtask> subtasks;
    HistoryManager historyManager;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this.sequenceId = 0;
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subtasks = new HashMap<>();
        this.historyManager = historyManager;
    }

    @Override
    public Task createTask(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        subtask.setId(generateId());
        subtasks.put(subtask.getId(), subtask);
        return subtask;
    }

    @Override
    public Epic createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
        return epic;
    }

    @Override
    public Task getTaskById(int id) {
        Task task = tasks.get(id);
        if (task == null) {
            return null;
        }
        historyManager.add(task);
        return task;
    }

    @Override
    public Task getSubtaskById(int id) {
        Subtask subtask = subtasks.get(id);
        if (subtask == null) {
            return null;
        }
        historyManager.add(subtask);
        return subtask;
    }

    @Override
    public Task getEpicById(int id) {
        Epic epic = epics.get(id);
        if (epic == null) {
            return null;

        }
        historyManager.add(epic);
        return epic;
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public List<Subtask> getAllSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public List<Task> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic) {
        Task saved = epics.get(epic.getId());
        saved.setName(epic.getName());
        saved.setId(epic.getId());
        saved.setDescription(epic.getDescription());
    }

    @Override
    public void updateSubtask(Subtask subtask) {
//        Epic epic = subtask.getEpic();
//        Epic savedEpic = epics.get(epic.getId());
//        calculateEpicStatus(savedEpic);
    }

    @Override
    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    @Override
    public void deleteSubtaskById(int id) {
        Subtask removeSubtask = subtasks.remove(id);

        Epic epic = removeSubtask.getEpic();
        Epic epicSaved = epics.get(epic.getId());

        epicSaved.getSubtasks().remove(removeSubtask);
        calculateEpicStatus(epicSaved);
    }

    @Override
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
