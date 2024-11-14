package ivanov.service;

import java.io.File;

public class HttpTaskManager extends FileBackedTaskManager{

    int port;

    public HttpTaskManager(File file) {
        super(file);
    }

    @Override
    protected void save() {
        super.save();
    }

    @Override
    public FileBackedTaskManager loadFromFile(File file) {
        return super.loadFromFile(file);
    }
}
