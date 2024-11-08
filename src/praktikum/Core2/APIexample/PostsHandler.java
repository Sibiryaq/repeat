package praktikum.Core2.APIexample;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostsHandler implements HttpHandler {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private static final Gson gson = new Gson();
    private static final List<Post> posts = new ArrayList<>();

    static {
        Post post1 = new Post(1, "Это первый пост, который я здесь написал.");
        post1.addComment(new Comment("Пётр Первый", "Я успел откомментировать первым!"));
        posts.add(post1);

        Post post2 = new Post(22, "Это будет второй пост. Тоже короткий.");
        posts.add(post2);

        Post post3 = new Post(333, "Это пока последний пост.");
        posts.add(post3);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Endpoint endpoint = getEndpoint(exchange.getRequestURI().getPath(), exchange.getRequestMethod());

        switch (endpoint) {
            case GET_POSTS -> handleGetPosts(exchange);
            case GET_COMMENTS -> handleGetComments(exchange);
            case POST_COMMENT -> handlePostComments(exchange);
            default -> writeResponse(exchange, "Такого эндпоинта еще не существует", 404);
        }
    }

    void handlePostComments(HttpExchange exchange) throws IOException {
        Optional<Integer> postIdOpt = getPostId(exchange);
        if (postIdOpt.isPresent()) {
            int postId = postIdOpt.get();
            try {
                InputStream inputStream = exchange.getRequestBody();
                String body = new String(inputStream.readAllBytes(), DEFAULT_CHARSET);

                Comment comment = gson.fromJson(body, Comment.class);
                if (comment.getText().equals("") || comment.getUser().equals("")) {
                    writeResponse(exchange, "Поля комментария не могут быть пустыми", 400);
                    return;
                } else {
                    boolean postFound = false;
                    for (Post post : posts) {
                        if (post.getId() == postId) {
                            post.addComment(comment);
                            postFound = true;
                            writeResponse(exchange, "Комментарий добавлен", 201);
                            break;
                        }
                    }
                    if (!postFound) {
                        writeResponse(exchange, "Пост с идентификатором " + postId + " не найден", 404);
                    }
                }
                inputStream.close();

            } catch (JsonSyntaxException e) {
                writeResponse(exchange, "Получен некорректный JSON", 400);
            }
        } else {
            writeResponse(exchange, "Некорректный идентификатор поста", 400);
        }

    }

    Endpoint getEndpoint(String requestPath, String requestMethod) {
        String[] pathParts = requestPath.split("/");
        if (pathParts.length == 2 && pathParts[1].equals("posts")) {
            return Endpoint.GET_POSTS;
        }
        if (pathParts.length == 4 && pathParts[1].equals("posts") && pathParts[3].equals("comments")) {
            if (requestMethod.equals("GET")) {
                return Endpoint.GET_COMMENTS;
            }
            if (requestMethod.equals("POST")) {
                return Endpoint.POST_COMMENT;
            }
        }
        return Endpoint.UNKNOWN;
    }

    void handleGetPosts(HttpExchange exchange) throws IOException {
        writeResponse(exchange, gson.toJson(posts), 200);

    }

    void handleGetComments(HttpExchange exchange) throws IOException {
        Optional<Integer> postIdOPt = getPostId(exchange);
        if (postIdOPt.isEmpty()) {
            writeResponse(exchange, "Некорректный идентификатор поста", 400);
            return;
        }
        int postId = postIdOPt.get();
        for (Post post : posts) {
            if (post.getId() == postId) {
                String commentsJson = gson.toJson(post.getCommentaries());
                writeResponse(exchange, commentsJson, 200);
                return;
            }
        }

    }

    Optional<Integer> getPostId(HttpExchange exchange) {
        String[] pathParts = exchange.getRequestURI().getPath().split("/");
        try {
            return Optional.of(Integer.parseInt(pathParts[2]));
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }
    }

    void writeResponse(HttpExchange exchange, String responseString, int responseCode) throws IOException {
        if (responseString.isBlank()) {
            exchange.sendResponseHeaders(responseCode, 0);
        } else {
            byte[] bytes = responseString.getBytes(DEFAULT_CHARSET);
            exchange.sendResponseHeaders(responseCode, 0);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
        exchange.close();

    }
}
