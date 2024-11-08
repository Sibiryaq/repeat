package praktikum.Core2.InternetHTTP;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class HelloHandler implements HttpHandler {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // http://localhost:8080/hello
        String method = httpExchange.getRequestMethod();
        System.out.println("Началась обработка " + method + " /hello запроса от клиента.");

        String path = httpExchange.getRequestURI().getPath();
        String name = path.split("/")[2];
        System.out.println("Имя: " + name);

        String response = "Привет, " + name + "!";
        httpExchange.sendResponseHeaders(200, 0);

        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes(StandardCharsets.UTF_8));
        }

        Headers headers = httpExchange.getResponseHeaders();
        headers.set("Content-Type", "text/plain");
        headers.set("X-your-own-header", "any-information-you-want");

    }
}
