package praktikum.Core2.JsonSerialized.practice;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {
    private static final DateTimeFormatter formatterWriter = DateTimeFormatter.ofPattern("dd--MM--yyyy");
    private static final DateTimeFormatter formatterReader = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    @Override
    public void write(final JsonWriter jsonWriter, final LocalDate localDate) throws IOException {
        // приводим localDate к необходимому формату
        jsonWriter.value(localDate.format(formatterWriter));
    }

    @Override
    public LocalDate read(final JsonReader jsonReader) throws IOException {
        return LocalDate.parse(jsonReader.nextString(), formatterReader);
    }



}
