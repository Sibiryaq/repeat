package ivanov.repository;

import com.google.gson.Gson;
import ivanov.server.KVClient;
import ivanov.service.Managers;

public class HttpTaskRepository extends TaskRepository {
    private KVClient client;
    private Gson gson = Managers.getGson();

    public HttpTaskRepository(int port) {
        this.client = new KVClient(port);
    }

    public HttpTaskRepository(KVClient client) {
        this.client = client;
    }
}
