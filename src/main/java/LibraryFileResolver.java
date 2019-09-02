import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LibraryFileResolver {
    private String path;


    LibraryFileResolver(String path) {
        this.path = path;
    }


    public void writeFile(List<Film> library, String fileName) {
        String path = this.path + fileName + ".csv";
        Path pathP = Paths.get(path);
        try {
            if (Files.exists(pathP)) Files.delete(pathP);
            Files.createFile(pathP);
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(path))) {
                for (Film p : library) {
                    String line = p.getTitle() + "," + p.getDirector() + "," + p.getYearOfProduction() + "," + p.getFilmType();
                    printWriter.println(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Wystąpił problem z plikiem");
        }
    }

    public void readFile(String fileName, List<Film> library) {
        Path pathD = Paths.get(this.path);
        Path path = Paths.get(this.path + fileName + ".csv");
        try {
            if (Files.notExists(pathD)) Files.createDirectory(pathD);
            if (Files.notExists(path)) {
                Files.createFile(path);
            } else {
                List<String> libraryStr = new ArrayList<>();
                libraryStr = Files.readAllLines(path);
                for (String line : libraryStr) {
                    String[] el = line.split(",");
                    Film film = new Film.FilmBuilder()
                            .title(el[0])
                            .director(el[1])
                            .yearOfProduction(Integer.parseInt(el[2]))
                            .gatunek(FilmType.valueOf(el[3]))
                            .build();
                    library.add(film);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Wystąpił problem z odczytem z pliku");
        }
    }


}
