import ivanov.model.Task;
import ivanov.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class TaskManagerTest<T extends TaskManager> {

    protected T taskManager;

    abstract void init();

    @Test
    void createTask() {
        Task task = new Task();
        Task result = taskManager.createTask(task);
        assertNotNull(result);
        assertTrue(result.getId() > 0, "Task Id");
        assertEquals(task.getName(), result.getName(), "Task name");
    }


}