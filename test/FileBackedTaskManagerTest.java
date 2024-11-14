import ivanov.service.FileBackedTaskManager;

import java.io.File;

class FileBackedTaskManagerTest extends TaskManagerTest<FileBackedTaskManager> {

    @Override
    void init() {
        taskManager = new FileBackedTaskManager(new File("data/data.csv"));
    }
}