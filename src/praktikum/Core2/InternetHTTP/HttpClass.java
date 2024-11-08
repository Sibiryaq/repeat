package praktikum.Core2.InternetHTTP;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpClass {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);

        httpServer.createContext("/hello", new HelloHandler()); //http://server-address:8080/hello
        //httpServer.createContext("day", new DayHandler());

        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");// http://localhost:8080/hello
    }








}
