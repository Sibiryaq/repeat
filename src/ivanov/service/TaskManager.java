package ivanov.service;

import ivanov.model.Epic;
import ivanov.model.Subtask;
import ivanov.model.Task;

import java.util.List;

public interface TaskManager {
    Task createTask(Task task);

    Subtask createSubtask(Subtask subtask);

    Epic createEpic(Epic epic);

    Task getTaskById(int id);

    Task getSubtaskById(int id);

    Task getEpicById(int id);

    List<Task> getAllTasks();

    List<Subtask> getAllSubtasks();

    List<Task> getAllEpics();

    void updateTask(Task task);

    void updateEpic(Epic epic);

    void updateSubtask(Subtask subtask);

    void deleteTaskById(int id);

    void deleteSubtaskById(int id);

    void deleteEpicById(int id);


}
