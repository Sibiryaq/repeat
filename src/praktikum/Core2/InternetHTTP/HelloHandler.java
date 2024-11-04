package praktikum.Core2.InternetHTTP;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HelloHandler implements HttpHandler {

    @Override
    // через httpExchange можно получить метод, заголовки и тело запроса
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = "Hey! Glad to see you on our server.";
        httpExchange.sendResponseHeaders(200, 0);
        // 200 - код ответа, 0 - длина в байтах, если 0 то размер не учитывается
        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }

    }
}
