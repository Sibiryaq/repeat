package praktikum.Core2.InternetHTTPJson;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpClass {

    public HttpClass() throws IOException {
    }

    HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
    // сервер будет слушать 8080 порт, 2ой параметр  backlog - число соединений
    //которые могут находиться в ожидании, пока сервер обрабатывает текущий запрос

    //мы не указали конкретный IP-адрес — это значит, что наш сервер будет по умолчанию использовать
    //все доступные на компьютере сети.

    //Итак, созданный нами веб-сервер будет работать на всех доступных IP-адресах,
    // слушать порт 8080 и обрабатывать стандартное число соединений, предусмотренное операционной системой.



}
