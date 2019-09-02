import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String key = "";
        String keySure = "n";
        Library library = Library.getInstanceLibrary();
        LibraryFileResolver libraryFileResolver = new LibraryFileResolver(Constatnts.pathStorage);
        libraryFileResolver.readFile(Constatnts.filName, library.getLibrary());
        while (!(key.equals("0") && (keySure.equals("t")))) {
            System.out.println("Menu:");
            System.out.println("1 - dodaj film");
            System.out.println("2 - skasuj film");
            System.out.println("3 - lista filmów");
            System.out.println("9 - zapisz zmiany do pliku");
            System.out.println("0 - wyjdź z programu");
            System.out.println("Ilość filmów w bibliotece wynosi: " + library.getLibrary().size());
            Scanner input = new Scanner(System.in);
            try {
                key = InputMainMenuChecker.getKeyPressed(input);
            } catch (InputMainMenuChecker.MenuInputException e) {
                System.out.println(e.getMessage());
            }
            switch (key) {
                case "1": {
                    System.out.println("Podaj tytuł filmu: ");
                    String title = input.nextLine();
                    System.out.println("Podaj reżysera filmu: ");
                    String director = input.nextLine();
                    System.out.println("Podaj rok produkcji filmu: ");
                    int year = 0;
                    boolean condition = true;
                    while (condition) {
                        try {
                            year = InputMainMenuChecker.getYearTyped(input);
                            condition = false;
                        } catch (InputMainMenuChecker.MenuInputException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Podaj jeszcze raz");
                        }
                    }
                    System.out.println("Podaj gatunek, jeden z: " + Arrays.asList(FilmType.values()));
                    FilmType filmType = null;
                    while (filmType == null) {
                        try {
                            filmType = InputMainMenuChecker.getGatunekTyped(input);
                        } catch (InputMainMenuChecker.MenuInputException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Podaj jeszcze raz");
                        }
                    }
                    Film film = new Film.FilmBuilder()
                            .title(title)
                            .director(director)
                            .yearOfProduction(year)
                            .gatunek(filmType)
                            .build();
                    library.addFilmToLibrary(film);
                    break;
                }
                case "2": {
                    System.out.println("Podaj tytuł filmu do skasowania: ");
                    String title = input.nextLine();
                    System.out.println("Podaj reżysera filmu do skasowania: ");
                    String director = input.nextLine();
                    if (library.deleteFilm(title, director)) {
                        System.out.println("Film został skasowany");
                    } else {
                        System.out.println("Film nie został skasowany, nie znaleziono filmu");
                    }
                    break;
                }
                case "3": {
                    library.listFilms();
                    break;
                }
                case "9": {
                    libraryFileResolver.writeFile(library.getLibrary(), Constatnts.filName);
                    break;
                }

                case "0": {
                    System.out.println("Na pewno wyjść? T(t)/N(n)");
                    keySure = input.nextLine().toLowerCase();
                    break;

                }
                default: {
                    System.out.println("Wybierz cyfrę 1,2,3,9 lub 0");
                }


            }
        }
    }

}
