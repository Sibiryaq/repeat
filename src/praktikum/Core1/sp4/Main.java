package praktikum.Core1.sp4;

import praktikum.Core1.sp4.model.Epic;
import praktikum.Core1.sp4.model.Subtask;
import praktikum.Core1.sp4.model.Task;
import praktikum.Core1.sp4.service.HistoryManager;
import praktikum.Core1.sp4.service.Managers;
import praktikum.Core1.sp4.service.TaskManager;
import praktikum.Core1.sp4.service.TaskStatus;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();
        HistoryManager memory = Managers.getDefaultHistory();

        Task taskFirst = new Task("Покушать", "Съесть бургер");
        manager.taskCreator(taskFirst); // 1
        Task taskSecond = new Task("Поспать", "Выспаться");
        manager.taskCreator(taskSecond); // 2

        Epic epicTaskFirst = new Epic("Закончить учебу", "Получить сертификат обучения");
        manager.epicCreator(epicTaskFirst); // 3
        Subtask subtaskFirst = new Subtask("Закончить учебу", "Сдать все спринты", 3);
        manager.subtaskCreator(subtaskFirst); //  4
        Subtask subtaskSecond = new Subtask("Закончить учебу", "Сдать дипломный проект", 3);
        manager.subtaskCreator(subtaskSecond); // 5


        Epic epicTaskSecond = new Epic("Сменить работу", "Начать работать Java разработчиком");
        manager.epicCreator(epicTaskSecond); // 6
        Subtask subtaskThird = new Subtask("Сменить работу", "Сдать дипломный проект", 6);
        manager.subtaskCreator(subtaskThird); //7

        System.out.println("\n    Получение списка всех задач:");
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());

        System.out.println("\n    Получение по идентификатору:");
        System.out.println(manager.getTasks());
        System.out.println(manager.getTaskById(2));
        System.out.println(manager.getEpics());
        System.out.println(manager.getEpicById(4));
        System.out.println(manager.getSubtasks());
        System.out.println(manager.getSubtaskById(5));

        System.out.println("\n    Обновление. Новая версия объекта с верным идентификатором " +
                "передаются в виде параметра:");

        taskFirst = manager.getTaskById(1);
        taskFirst.setStatus(TaskStatus.DONE);
        manager.updateTask(taskFirst);
        System.out.println(manager.getTasks());
        subtaskFirst = manager.getSubtaskById(4);
        subtaskFirst.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtaskFirst);
        System.out.println(manager.getSubtasks());
        subtaskSecond = manager.getSubtaskById(5);
        subtaskSecond.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtaskSecond);

        System.out.println(manager.getSubtasks());

        System.out.println("\n    Получение списка всех подзадач определённого эпика:");
        System.out.println(manager.getAllSubtasks(epicTaskFirst));
        System.out.println(manager.getAllSubtasks(epicTaskSecond));

        System.out.println("\n    Удаление по идентификатору:");
        manager.deleteEpic(3);
        System.out.println(manager.getEpicById(4));
        manager.deleteTask(2);
        System.out.println(manager.getTaskById(2));
        manager.deleteSubtask(4);
        System.out.println(manager.getSubtaskById(6));
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());

        System.out.println("\n    Удаление всех задач:");
        manager.deleteTaskList();
        manager.deleteEpicList();
        manager.deleteSubtaskList();
        System.out.println(manager.getTasks());
        System.out.println(manager.getSubtasks());
        System.out.println(manager.getEpics());

        Task task = new Task("Остудить мозг", "Погулять, подышать, поспать");    //  8
        manager.taskCreator(task);

        task = new Task("Остудить мозг №1", "Погулять, подышать, поспать");     // #9
        manager.taskCreator(task);

        task = new Task("Остудить мозг №2", "Погулять, подышать, поспать");     // #10
        manager.taskCreator(task);

        task = new Task("Остудить мозг №3", "Погулять, подышать, поспать");     // #11
        manager.taskCreator(task);

        task = new Task("Остудить мозг №4", "Погулять, подышать, поспать");     // #12
        manager.taskCreator(task);

        task = new Task("Остудить мозг №5", "Погулять, подышать, поспать");     // #13
        manager.taskCreator(task);

        task = new Task("Остудить мозг №6", "Погулять, подышать, поспать");     // #14
        manager.taskCreator(task);

        task = new Task("Остудить мозг №7", "Погулять, подышать, поспать");     // #15
        manager.taskCreator(task);

        task = new Task("Остудить мозг №8", "Погулять, подышать, поспать");     // #16
        manager.taskCreator(task);

        task = new Task("Остудить мозг №9", "Погулять, подышать, поспать");     // #17
        manager.taskCreator(task);

        task = new Task("Остудить мозг №10", "Погулять, подышать, поспать");     // #18
        manager.taskCreator(task);

        manager.getTaskById(9);
        manager.getTaskById(10);
        manager.getTaskById(11);
        manager.getTaskById(12);
        manager.getTaskById(13);
        manager.getTaskById(14);
        manager.getTaskById(15);
        manager.getTaskById(16);
        manager.getTaskById(17);
        manager.getTaskById(18);


        System.out.println("Проверка вывода последних 10ти тасков");
        memory.printHistory();

        Epic epic = new Epic("Эпик1", "Описание эпик1");        // #19
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_1", "Точно пора гулять...");     // #20
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_2", "Точно пора гулять...");     // #21
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_3", "Точно пора гулять...");     // #22
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_4", "Точно пора гулять...");     // #23
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_5", "Точно пора гулять...");     // #24
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_6", "Точно пора гулять...");     // #25
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_7", "Точно пора гулять...");     // #26
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_8", "Точно пора гулять...");     // #27
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_9", "Точно пора гулять...");     // 28
        manager.epicCreator(epic);
        epic = new Epic("Надеюсь, в этот раз ты запустишься_10", "Точно пора гулять...");     // #29
        manager.epicCreator(epic);

        Subtask subtask = new Subtask("Подзадача1", "Описание п-задачи1", 19);       // #30
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_1", "А может и нет", 20);      // #31
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_2", "А может и нет", 21);      // #32
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_3", "А может и нет", 22);      // #33
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_4", "А может и нет", 23);      // #34
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_5", "А может и нет", 24);      // #35
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_6", "А может и нет", 25);      // #36
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_7", "А может и нет", 26);      // #37
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_8", "А может и нет", 27);      // #38
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_9", "А может и нет", 28);      // #39
        manager.subtaskCreator(subtask);
        subtask = new Subtask("Еще чуть-чуть_10", "А может и нет", 29);      // #40
        manager.subtaskCreator(subtask);

        manager.getEpicById(19);
        manager.getEpicById(20);
        manager.getEpicById(21);
        manager.getEpicById(22);
        manager.getEpicById(23);
        manager.getEpicById(24);
        manager.getEpicById(25);
        manager.getEpicById(26);
        manager.getEpicById(27);
        manager.getEpicById(28);
        manager.getEpicById(29);

        System.out.println("Проверка вывода последних 10ти эпиков'");
        memory.printHistory();

        manager.getSubtaskById(30);
        manager.getSubtaskById(31);
        manager.getSubtaskById(32);
        manager.getSubtaskById(33);
        manager.getSubtaskById(34);
        manager.getSubtaskById(35);
        manager.getSubtaskById(36);
        manager.getSubtaskById(37);
        manager.getSubtaskById(38);
        manager.getSubtaskById(39);
        manager.getSubtaskById(40);

        System.out.println("Проверка вывода последних 10ти сабтасков");
        memory.printHistory();

        manager.getTaskById(15);
        manager.getTaskById(20);
        manager.getTaskById(25);
        manager.getSubtaskById(47);
        manager.getEpicById(31);
        manager.getEpicById(32);
        manager.getSubtaskById(43);
        manager.getSubtaskById(44);
        manager.getEpicById(34);
        manager.getTaskById(26);
        manager.getSubtaskById(39);
        manager.getSubtaskById(40);
        manager.getTaskById(22);
        manager.getTaskById(23);
        manager.getEpicById(36);

        System.out.println("Проверка вывода последних 10ти просмотров");
        memory.printHistory();


    }

}