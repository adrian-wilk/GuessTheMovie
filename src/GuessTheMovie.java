import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;


public class GuessTheMovie {

    public static void main(String[] args) throws Exception {

        // Guessing the title should end the game. Initial isCorrect value set to false.
        boolean isCorrect = false;

        File movieTitle = new File("movies.txt");
        Scanner movieScanner = new Scanner(movieTitle);

        // The movies file may be changed and new titles may be added. Therefore let's count how many movies is there before we proceed.
        int titlesNumber = 0;

        while (movieScanner.hasNextLine()) {
            String line = movieScanner.nextLine();
            titlesNumber += (line.split("\n").length); // "\n" stands for next line which is the divider between movie titles.
        }

        // Now when the number of movies is known, let's generate a random number from 1 to x, where x is the number of movies.
        int randomMovieNumber = (int) (Math.random() * titlesNumber);

        // randomMovieTitle will generate a random movie basing on reading random line number from movies.txt.
        String randomMovieTitle = Files.readAllLines(Paths.get("movies.txt")).get(randomMovieNumber);

        String hiddenMovieTitle = randomMovieTitle.replaceAll("[a-zA-Z]", "_");

        System.out.println(randomMovieTitle);
        System.out.println(hiddenMovieTitle);




    }

    }



