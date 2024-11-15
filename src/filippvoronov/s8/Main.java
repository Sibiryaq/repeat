package filippvoronov.s8;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    final static String YANDEX_API_KEY = "AQAA*******************xSk0";
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(PORT), 0);

        server.createContext("/index.html", h -> {
            try (h) {
                var htmlContent = """
                        <html>
                        <head>
                            <title>Uploader</title>
                            <script>
                                function uploadFile() {
                                    let url = prompt("Enter url to upload");
                                    if (url) {
                                        console.log(url);
                                        fetch('/upload', {
                                            'method': 'POST',
                                            'body': url
                                        });
                                    }
                                }
                            </script>
                        </head>
                        <body>
                            <button onclick="uploadFile()">Upload</button>
                        </body>
                        </html>
                        """;
                h.sendResponseHeaders(200, htmlContent.getBytes(StandardCharsets.UTF_8).length); //???
                h.getResponseBody().write(htmlContent.getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                System.out.println("FAIL index.html");
            }
        });

        server.createContext("/upload", h -> {
            try (h) {
                String url = new String(h.getRequestBody().readAllBytes());
                System.out.println(url);
                String[] urlParts = url.split("\\.");
                String ext = urlParts[urlParts.length - 1];
                HttpRequest yaRequest = HttpRequest.newBuilder()
                        .uri(URI.create("https://cloud-api.yandex.net/v1/disk/resources/upload?url=" +
                                URLEncoder.encode(url, Charset.defaultCharset()) +
                                "&path=Uploads/" + System.currentTimeMillis() + "." + ext
                        ))
                        .header("Authorization", "OAuth" + YANDEX_API_KEY)
                        .POST(HttpRequest.BodyPublishers.noBody())
                        .build();
                HttpResponse response = HttpClient.newHttpClient().send(yaRequest, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                h.sendResponseHeaders(response.statusCode(), 0);
            } catch (InterruptedException e){
                h.sendResponseHeaders(500, 0);
            }
        });

        server.start();
    }
}
