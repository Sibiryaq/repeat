package praktikum.Core2.InternetHTTP;

public class Main {
    public static void main(String[] args) {
        String resource = "/profile/java-developer";
        String protocol = "https://";
        String server = "practicum.yandex.ru";

        String URL = protocol + server + resource;
        System.out.println(URL);
        String[] httpMethods = {"POST - создание",
                "GET - получение",
                "PUT -  передача даннных, заменяет существующие данные или при их отсутствии создает новый ресурс",
                "PATCH - частичное обновление",
                "DELETE - удаление ресурса"};
        String[] responseCodes = {
                "2xx - все ок",
                "4xx - клиентские ошибки, некорректные запросы и т.д.",
                "5хх - коды серверных ошибок, сбой, нагружен, перезагружается ит.д.",
                "3хх - перенаправление"};
        //API - набор URL адресов и соглашений об их использовании, своеобразный интерфейс


    }
}
