package ivanov.service;

public class Managers {
    public static TaskManager getDefaultTaskManager() {
        return new InMemoryTaskManager(getDefaultHistory());
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
