package praktikum.Enum;

import java.util.ArrayList;
import java.util.List;

public class Practicum {
    public static void main(String[] args) {

        List<Film> films = new ArrayList<>();
        films.add(new Film("Зелёная миля", FilmGenre.DRAMA));
        films.add(new Film("Побег из Шоушенка", FilmGenre.DRAMA));
        films.add(new Film("Властелин колец: Братство Кольца", FilmGenre.FANTASY));
        films.add(new Film("Король Лев", FilmGenre.FAMILY));

        filterByGenre(films, FilmGenre.DRAMA);
    }

    public static void filterByGenre(List<Film> films, FilmGenre genre) {
        if (genre.getClass().equals(FilmGenre.class)) {
            System.out.println(genre.getClass()); // class praktikum.Enum.FilmGenre
        }
        for (Film film : films) {
            // Сравнение жанра фильма из списка с искомым жанром:
            if (film.getGenre().equals(genre)) {
                System.out.println(film.getTitle());
            }
        }

        System.out.println("Жанры в enum");
        for (FilmGenre value : FilmGenre.values()) {
            System.out.print(value + " ");
        }
    }
}
