package praktikum.Core1.sp4.service;

import praktikum.Core1.sp4.model.*;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {

    void taskCreator(Task task);
    void subtaskCreator(Subtask subtask);
    void epicCreator(Epic epic);

    List<Task> getTasks();
    List<Subtask> getSubtasks();
    List<Epic> getEpics();

    void deleteTaskList();
    void deleteSubtaskList();
    void deleteEpicList();

    Task getTaskById(int id);
    Subtask getSubtaskById(int id);
    Epic getEpicById(int id);

    void deleteTask(int id);
    void deleteSubtask(int id);
    void deleteEpic(int id);

    void updateTask(Task task);
    void updateSubtask(Subtask subtask);
    void updateEpic(Epic epic);

    boolean checkStatus(TaskStatus tStatus, Epic epic);
    void updateStatusEpic(Epic epic);

    ArrayList<Subtask> getAllSubtasks(Epic epic);
    List<Task> getHistory();


}
