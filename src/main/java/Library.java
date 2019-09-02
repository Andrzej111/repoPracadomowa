import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Film> library;
    private static Library instanace = new Library();

    private Library() {
        library = new ArrayList<>();
    }

    public static Library getInstanceLibrary() {
        return instanace;
    }

    public List<Film> getLibrary() {
        return library;
    }

    public void addFilmToLibrary(Film film) {
        library.add(film);
    }

    public void listFilms() {
        for (Film el : library) {
            System.out.println("Film " + (library.indexOf(el) + 1));
            System.out.println("Tytuł: " + el.getTitle() + ", Reżyser: " + el.getDirector()
                    + ", Rok produkcji: " + el.getYearOfProduction() + ", Gatunek: " + el.getFilmType());

        }
    }

    public boolean deleteFilm(String title, String director) {
        boolean condition = false;
        Film elTmp = null;
        for (Film el : library) {
            if ((el.getTitle().equals(title) && (el.getDirector().equals(director)))) {
                condition = true;
                elTmp = el;
                break;
            }
        }
        library.remove(elTmp);
        return condition;
    }


}
