package ivanov.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ivanov.server.InstantAdapter;

import java.time.Instant;

public class Managers {
    public static TaskManager getDefaultTaskManager() {
        return new InMemoryTaskManager(getDefaultHistory());
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static Gson getGson() {
        return new GsonBuilder().
                registerTypeAdapter(Instant.class, new InstantAdapter()).
                create();

    }
}
