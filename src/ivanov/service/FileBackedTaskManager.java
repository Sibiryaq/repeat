package ivanov.service;


import ivanov.exceptions.ManagerSaveException;
import ivanov.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.List;

public class FileBackedTaskManager extends InMemoryTaskManager {
    private final File file;

    public FileBackedTaskManager(File file) {
        super(Managers.getDefaultHistory());
        this.file = file;
    }

    public static void main(String[] args) {
        FileBackedTaskManager manager = new FileBackedTaskManager(new File("data/data.csv"));
     //   FileBackedTaskManager manager1 = loadFromFile(Paths.get("data/data.csv").toFile());

        //Заведение нескольких разных задач, эпиков и подзадач.
        manager.createTask(new Task("Задача №1"));
        manager.createTask(new Task("Задача №2)"));

        Epic epic1 = new Epic("Эпик №1");
        manager.createEpic(epic1);

        //Вывод списка задач
        System.out.println("\n Cозданные Эпики : \n" + manager.getAllEpics());
        System.out.println("\n Созданные Задачи : \n" + manager.getAllTasks());
        System.out.println("\n Созданные Подзадачи : \n" + manager.getAllSubtasks());
        System.out.println("Всего создано задач - "
                + (manager.getAllTasks().size()
                + manager.getAllSubtasks().size()
                + manager.getAllEpics().size()));

    }

    @Override
    public Task createTask(Task task) {
        super.createTask(task);
        save();
        return task;
    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        super.createSubtask(subtask);
        save();
        return subtask;
    }

    @Override
    public Epic createEpic(Epic epic) {
        super.createEpic(epic);
        save();
        return epic;
    }

    @Override
    public Task getTaskById(int id) {
        Task task = super.getTaskById(id);
        save();
        return task;
    }

    @Override
    public Subtask getSubtaskById(int id) {
        Subtask subtask = super.getSubtaskById(id);
        save();
        return subtask;
    }

    @Override
    public Epic getEpicById(int id) {
        Epic epic = super.getEpicById(id);
        save();
        return epic;
    }

    @Override
    public void deleteTaskById(int id) {
        super.deleteTaskById(id);
        save();
    }

    @Override
    public void deleteSubtaskById(int id) {
        super.deleteSubtaskById(id);
        save();
    }

    @Override
    public void deleteEpicById(int id) {
        super.deleteEpicById(id);
        save();
    }

    @Override
    public void updateEpic(Epic epic) {
        super.updateEpic(epic);
        save();
    }

    @Override
    public void updateTask(Task task) {
        super.updateTask(task);
        save();
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        super.updateSubtask(subtask);
        save();
    }

    @Override
    public void deleteAllTask() {
        super.deleteAllTask();
        save();
    }

    @Override
    public void deleteAllSubtask() {
        super.deleteAllSubtask();
        save();
    }

    @Override
    public void deleteAllEpic() {
        super.deleteAllEpic();
        save();
    }

    public FileBackedTaskManager loadFromFile(File file) {
        FileBackedTaskManager fileBackedTaskManager = new FileBackedTaskManager(file);
        try {
            String data = Files.readString(Path.of(file.getAbsolutePath()));
            String[] lines = data.split("\n");
            boolean isTitle = true;
            boolean itsTask = true;
            int maxId = 0;

            for (String line : lines) {
                if (isTitle) {
                    isTitle = false;
                    continue;
                }
                if (line.isEmpty() || line.equals("\r")) {
                    itsTask = false;
                    continue;
                }
                if (itsTask) {
                    TaskType taskType = TaskType.valueOf(line.split(",")[1]);
                    setTask(taskType, line, maxId, fileBackedTaskManager);
                } else {
                    List<Integer> ids = fromString(line);
                    for (Integer taskId : ids) {
                        fileBackedTaskManager.historyManager.add(getTaskAllKind(taskId, fileBackedTaskManager));
                    }
                }
            }
            fileBackedTaskManager.sequenceId = maxId;
        } catch (IOException e) {
            throw new ManagerSaveException("Ошибка чтения файла.");
        }
        return fileBackedTaskManager;
    }

    protected void save() {
        try (Writer writer = new FileWriter(file)) {
            writer.write("id,type,name,status,description,epic\n");
            List<Task> allTasks = new ArrayList<>();

            allTasks.addAll(super.getAllTasks());
            allTasks.addAll(super.getAllEpics());
            allTasks.addAll(super.getAllSubtasks());

            for (Task task : allTasks) {
                writer.write(String.format("%s\n", task.toStringFromFile()));
            }
            writer.write("\n");
            writer.write(toString(this.historyManager));

        } catch (IOException e) {
            throw new ManagerSaveException("Ошибка записи файла.");
        }
    }

    private static Task getTaskAllKind(int id, InMemoryTaskManager inMemoryTaskManager) {
        Task task = inMemoryTaskManager.getAllTasks().get(id);
        if (!(task == null)) {
            return task;
        }
        Task epic = inMemoryTaskManager.getAllEpics().get(id);
        if (!(epic == null)) {
            return epic;
        }
        Task subtask = inMemoryTaskManager.getAllSubtasks().get(id);
        if (!(subtask == null)) {
            return subtask;
        }
        return null;
    }

    private static String toString(HistoryManager manager) {
        List<String> s = new ArrayList<>();
        for (Task task : manager.getHistory()) {
            s.add(String.valueOf(task.getId()));
        }
        return String.join(",", s);
    }

    private static List<Integer> fromString(String value) {
        String[] idsString = value.split(",");
        List<Integer> tasksId = new ArrayList<>();
        for (String idString : idsString) {
            tasksId.add(Integer.valueOf(idString));
        }
        return tasksId;
    }

    private static Task fromString(String value, TaskType taskType, FileBackedTaskManager fileBackedTasksManager) {
        String[] dataOfTask = value.split(",", 6);
        int id = Integer.parseInt(dataOfTask[0]);
        String name = dataOfTask[2];
        Status status = Status.valueOf(dataOfTask[3]);
        String description = dataOfTask[4];
        String epicIdString = dataOfTask[5].trim();

        switch (taskType) {
            case TASK:
       //         return new Task(id, name, description, status);
            case EPIC:
          //      return new Epic(id, name, status, description);
            case SUBTASK:
         //       return new Subtask(id, name, description, status, fileBackedTasksManager.epics.get(Integer.valueOf(epicIdString)));
            default:
                return null;
        }
    }

    private static Integer setTask(TaskType taskType, String line, int maxId, FileBackedTaskManager fileBackedTasksManager) {
        switch (taskType) { // p.s. СПАСИБО ОГРОМНОЕ!!!
            case EPIC:
                Epic epic = (Epic) fromString(line, TaskType.EPIC, fileBackedTasksManager);
                if (epic != null) {
                    int id = epic.getId();
                    if (id > maxId) {
                        maxId = id;
                    }
                    fileBackedTasksManager.epics.put(id, epic);
                }
                break;
            case SUBTASK:
                Subtask subtask = (Subtask) fromString(line, TaskType.SUBTASK, fileBackedTasksManager);
                if (subtask != null) {
                    int id = subtask.getId();
                    if (id > maxId) {
                        maxId = id;
                    }
                    fileBackedTasksManager.subtasks.put(id, subtask);
                }
                break;
            case TASK:
                Task task = fromString(line, TaskType.TASK, fileBackedTasksManager);
                if (task != null) {
                    int id = task.getId();
                    if (id > maxId) {
                        maxId = id;
                    }
                    fileBackedTasksManager.tasks.put(id, task);
                }
                break;
        }
        return maxId;
    }




}