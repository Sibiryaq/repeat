package ivanov.service;

import ivanov.model.Epic;
import ivanov.model.Status;
import ivanov.model.Subtask;
import ivanov.model.Task;

import java.util.*;

public class InMemoryTaskManager implements TaskManager {
    protected int sequenceId;
    protected HashMap<Integer, Task> tasks;
    protected HashMap<Integer, Epic> epics;
    protected HashMap<Integer, Subtask> subtasks;
    protected HistoryManager historyManager;
    TreeSet<Task> prioritizedTasks = new TreeSet<>(Comparator.comparingInt(Task::getDuration));

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
        prioritizedTasks.add(task);
        return task;
    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        subtask.setId(generateId());
        subtasks.put(subtask.getId(), subtask);
        subtask.getEpic().getSubtasks().add(subtask);
        calculateEpicStatus(subtask.getEpic());
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
    public Subtask getSubtaskById(int id) {
        Subtask subtask = subtasks.get(id);
        if (subtask == null) {
            return null;
        }
        historyManager.add(subtask);
        return subtask;
    }

    @Override
    public Epic getEpicById(int id) {
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
        if (tasks.containsKey(task.getId())) {
            Task saved = tasks.get(task.getId());

            saved.setId(task.getId());
            saved.setName(task.getName());
            saved.setDescription(task.getDescription());
            saved.setStatus(task.getStatus());
            saved.setStartTime(task.getStartTime());

            tasks.put(saved.getId(), saved);
        }
    }

    @Override
    public void updateEpic(Epic epic) {
        Epic saved = epics.get(epic.getId());

        saved.setId(epic.getId());
        saved.setName(epic.getName());
        saved.setDescription(epic.getDescription());
        saved.setStatus(epic.getStatus());
        saved.setStartTime(epic.getStartTime());
        saved.setSubtasks(epics.get(epic.getId()).getSubtasks());

        epics.put(saved.getId(), saved);
        calculateEpicStatus(saved);
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            Subtask saved = subtasks.get(subtask.getId());
            saved.setId(subtask.getId());
            saved.setName(subtask.getName());
            saved.setDescription(subtask.getDescription());
            saved.setStatus(subtask.getStatus());
            saved.setStartTime(subtask.getStartTime());
            saved.setEpic(subtask.getEpic());

            subtasks.put(subtask.getId(), subtask);
            calculateEpicStatus(subtask.getEpic());
        }
    }

    @Override
    public void deleteTaskById(int id) {
        if (tasks.containsKey(id)) {
            System.out.println("Задача с id# " + id + " удалена." + System.lineSeparator());

            tasks.remove(id);
            historyManager.remove(id);
        }
    }

    @Override
    public void deleteSubtaskById(int id) {
        if (subtasks.containsKey(id)) {
            System.out.println("Подзадача с id# " + id + " удалена." + System.lineSeparator());

            Subtask removeSubtask = subtasks.remove(id);
            Epic epic = removeSubtask.getEpic();
            Epic epicSaved = epics.get(epic.getId());
            epicSaved.getSubtasks().remove(removeSubtask);
            calculateEpicStatus(epicSaved);
            subtasks.remove(id);
            historyManager.remove(id);
        }
    }

    @Override
    public void deleteEpicById(int id) {
        if (epics.containsKey(id)) {
            System.out.println("Эпик с id# " + id + " удален." + System.lineSeparator());
            Epic epic = epics.get(id);
            for (Subtask subtask : epic.getSubtasks()) {
                subtasks.remove(subtask.getId());
                historyManager.remove(subtask.getId());
            }
            epics.remove(id);
            historyManager.remove(id);
        }
    }

    @Override
    public void deleteAllTask() {
        tasks.clear();
    }

    @Override
    public void deleteAllSubtask() {
        ArrayList<Epic> epicForStatusUpdate = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            subtask.getEpic().setSubtasks(new ArrayList<>());
            if (!epicForStatusUpdate.contains(subtask.getEpic())) {
                epicForStatusUpdate.add(subtask.getEpic());
            }
        }
        subtasks.clear();
        for (Epic epic : epicForStatusUpdate) {
            epic.setStatus(Status.NEW);
        }
    }

    @Override
    public void deleteAllEpic() {
        epics.clear();
        subtasks.clear();
    }

    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    private int generateId() {
        return ++sequenceId;
    }

    private void calculateEpicStatus(Epic epic) {
        if (epic.getSubtasks().isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }

        boolean allTaskIsNew = true;
        boolean allTaskIsDone = true;

        for (Subtask subtask : epic.getSubtasks()) {
            Status status = subtasks.get(subtask.getId()).getStatus();
            if (status != Status.NEW) {
                allTaskIsNew = false;
            }
            if (status != Status.DONE) {
                allTaskIsDone = false;
            }
        }

        if (allTaskIsDone) {
            epic.setStatus(Status.DONE);
        } else if (allTaskIsNew) {
            epic.setStatus(Status.NEW);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }


}
