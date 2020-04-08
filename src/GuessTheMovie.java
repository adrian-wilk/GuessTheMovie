import java.util.Scanner;
import java.io.File;


public class GuessTheMovie {

public static void main(String[] args) throws Exception {

    // Guessing the title should end the game. Initial isCorrect value set to false.
    boolean isCorrect = false;

    File movieTitle = new File("movies.txt");
    Scanner movieScanner = new Scanner(movieTitle);

    // The movies file may be changed and new titles may be added. Therefore let's count how many movies is there before we proceed.
    int titlesNumber=0;
    while(movieScanner.hasNextLine()){
        String line = movieScanner.nextLine();
        titlesNumber += (line.split("\n").length);
    }
System.out.println(titlesNumber);



}

}
