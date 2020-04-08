import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class RandomMovieTitle {

    public static String getRandomMovieTitle() throws Exception{

        File movieTitle = new File("movies.txt");
        Scanner movieScanner;
        movieScanner = new Scanner(movieTitle);

        int titlesNumber = 0;
        while (movieScanner.hasNextLine()) {
            String line = movieScanner.nextLine();
            titlesNumber += (line.split("\n").length);
        }

        int randomMovieNumber = (int) (Math.random() * titlesNumber);
        String anyMovieTitle = Files.readAllLines(Paths.get("movies.txt")).get(randomMovieNumber);
        return anyMovieTitle;
    }
    }
