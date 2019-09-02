import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputMainMenuChecker {

    public static class MenuInputException extends Exception {
        public MenuInputException(String message) {
            super(message);
        }
    }

    public static String getKeyPressed(Scanner input) throws MenuInputException {
        String in = input.nextLine();
        String patternString = "[0-9]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(in);
        if (!matcher.matches()) {
            throw new MenuInputException("Podałeś zły znak wyboru menu!");
        }
        return in;
    }

    public static int getYearTyped(Scanner input) throws MenuInputException {
        String in = input.nextLine();
        String patternString = "[0-9][0-9][0-9][0-9]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(in);
        if (!matcher.matches()) {
            throw new MenuInputException("Podaj rok w formacie \"yyyy\"");
        }
        return Integer.parseInt(in);
    }

    public static FilmType getGatunekTyped(Scanner input) throws MenuInputException {
        String in = input.nextLine();
        FilmType filmType = null;
        try {
            filmType = FilmType.valueOf(in);
        } catch (IllegalArgumentException e) {
            throw new MenuInputException("Niewłaściwe podałeś gatunek filmu");
        }
        return filmType;
    }

}
