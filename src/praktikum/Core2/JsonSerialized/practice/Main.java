package praktikum.Core2.JsonSerialized.practice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        String lastLikeInfoStr = "{ \"user\": \"Алексей\", \"hours\": 12, \"minutes\": 30}";

        Gson gson = new GsonBuilder()
                .serializeNulls() // если у обьекта Java какое-то поле null, по умолчанию такие оббъекты не попадут в JSO
                .setPrettyPrinting() // включили настройку для читабельной печати
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) //зарегистрировали написанный TypeAdapter
                .create();

        LastLikeInfo lastLikeInfo = gson.fromJson(lastLikeInfoStr, LastLikeInfo.class);// код десериализации

        LikesInfo likesInfo = new LikesInfo();
        likesInfo.setRepostsCount(10);
        likesInfo.setHasOwnerLiked(true);
        likesInfo.setLastLikeInfo(lastLikeInfo);
        likesInfo.setLikes(new Like[]{
                new Like("Алексей", "http://example.com/avatars/aleksey.jpg"),
                new Like("Елена", "http://example.com/avatars/elena.jpg"),
                new Like("Света", "http://example.com/avatars/sveta.jpg"),
        });

        String serializedLikesInfo = gson.toJson(likesInfo);// код сериализации
        System.out.println(serializedLikesInfo);
    }
}
