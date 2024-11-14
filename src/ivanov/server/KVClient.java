package ivanov.server;

import ivanov.exceptions.ManagerSaveException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class KVClient {
    private final String url;
    private String token;

    public KVClient(int port) {
        url = "http://localhost:" + port + "/";
    }

    private void register() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + "register"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ManagerSaveException("Can't do save request, status code: " + response.statusCode())
            }
            token = response.body();
        } catch (IOException | InterruptedException e) {
            throw new ManagerSaveException("Can't do save request");
        }
    }
}
