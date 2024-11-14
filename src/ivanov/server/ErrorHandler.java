package ivanov.server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import ivanov.exceptions.ManagerSaveException;
import ivanov.service.Managers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ErrorHandler {
    Gson gson = Managers.getGson();

    public void handle(HttpExchange h, ManagerSaveException e) throws IOException {
        e.printStackTrace();
        sendText(h,400, gson.toJson(e));
    }

    public void handle(HttpExchange h, Exception e) throws IOException {
        e.printStackTrace();
        sendText(h,500, gson.toJson(e));
    }

    protected void sendText(HttpExchange h, int code, String text) throws IOException {
        byte[] resp = text.getBytes(StandardCharsets.UTF_8);
        h.getResponseHeaders().add("Content-Type", "application/json");
        h.sendResponseHeaders(code, resp.length);
        h.getResponseBody().write(resp);
    }
}
