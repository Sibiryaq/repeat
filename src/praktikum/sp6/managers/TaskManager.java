package praktikum.sp6.managers;

import praktikum.sp6.tasks.Epic;
import praktikum.sp6.tasks.SubTask;
import praktikum.sp6.tasks.Task;

import java.util.List;

public interface TaskManager {
    List<Task> getTasks();

    List<Epic> getEpics();

    List<SubTask> getSubTasks();

    void addTask(Task task);

    void addEpic(Epic epic);

    void addSubTask(SubTask subTask, int epicId);

    Task getTaskById(int id);

    Epic getEpicById(int id);

    SubTask getSubTaskById(int id);

    void deleteTasks();

    void deleteEpics();

    void deleteSubTasks(int epicId);

    void printTask();

    void printEpic();

    void printSubTask();

    void deleteTask(int id);

    void deleteEpic(int id);

    void deleteSubTask(int id, int epicId);

    Task getTask(int id);

    Epic getEpic(int id);

    SubTask getSubTask(int id);

    void updateTask(int newId, Task task);

    void updateEpic(int newId, Epic e);

    void updateSubTask(int epicId, SubTask st);

    void updateEpicStatus(int epicId);

    List<SubTask> getSubTasksByEpicId(int epicId);

    List<Task> getHistory();

}
