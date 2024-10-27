package praktikum.OOP.Interface;

import java.util.ArrayList;
import java.util.List;

public class CalendarApp implements NoteBook{
    List<String> notes = new ArrayList<>();

    @Override
    public void addNote(String note) {
        notes.add(note);
        System.out.println("Заметка успешно добавлена!");
    }

    @Override
    public void deleteNote(int index) {
        if (index < 0 || index >= notes.size()) {
            System.out.println("Неверный индекс для удаления заметки");
        } else {
            notes.remove(index);
            System.out.println("Заметка успешно удалена!");
        }

    }
}
