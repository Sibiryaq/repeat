package praktikum.Core2.InternetHTTP;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpClass {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // сервер будет слушать 8080 порт, 2ой параметр  backlog - число соединений
        //которые могут находиться в ожидании, пока сервер обрабатывает текущий запрос

        //мы не указали конкретный IP-адрес — это значит, что наш сервер будет по умолчанию использовать
        //все доступные на компьютере сети.

        //Итак, созданный нами веб-сервер будет работать на всех доступных IP-адресах,
        // слушать порт 8080 и обрабатывать стандартное число соединений, предусмотренное операционной системой.
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler()); //http://server-address:8080/hello
        httpServer.createContext("day", new DayHandler());
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");// http://localhost:8080/hello
    }








}