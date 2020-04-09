import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;


public class GuessTheMovie {

    private boolean isCorrect;
    private String rightLetters;
    private String wrongLetters;
    private int chancesLeft;
    private String movieToBeGuessed;

    public GuessTheMovie(String args) throws Exception {

        isCorrect = false;
        rightLetters = "";
        wrongLetters = "";
        chancesLeft = 10;
        movieToBeGuessed = RandomMovieTitle.getRandomMovieTitle();
    }

    public String getMovieTitle() {
        return movieToBeGuessed;
}

        // Method getHiddenMovieTitle replaces all the letters from the movie title to "_", except the letters guessed correctly.
        public String getHiddenMovieTitle () {
            if (rightLetters.equals("")) {
                return movieToBeGuessed.replaceAll("[a-zA-Z]", "_");
            } else {
                return movieToBeGuessed.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "_");
            }
        }

        // Method getWrongLetters returns the letters typed in by user, which do not match the movie title letters.
        public String getWrongLetters(){
        return wrongLetters;
        }

        // Method Victory returns true if the user guessed the movie title.
        public boolean Victory(){
        return isCorrect;
        }

        /* Method endOfTheGame verifies if any of two conditions is met: a) user lost all his chances to guess
        b)user guessed all the movie's letters correctly. In this case the user won the game*/

        public boolean endOfTheGame() {
            if (chancesLeft == 0 ) {
                return true;
            }
            if (!getHiddenMovieTitle().contains("_")){
                isCorrect = true;
                return true;
            }
            return false;
        }

        public int getChancesLeft(){
            return chancesLeft;
    }



        /* Method isCorrectLetter checks if the user input is correct and if it is the first time
        that user typed specific letter.*/
        private String isCorrectLetter(){
            System.out.println("Try to guess a letter from the hidden movie title: ");
            Scanner letterScanner = new Scanner(System.in);
            String guessedLetter = letterScanner.nextLine();

            // The input must be a lower case letter. Any other input cannot be accepted.
            if(!guessedLetter.matches("[a-z]")){
                System.out.println("Only single, lower case letters from english alphabet are accepted. Please try again.");
                return isCorrectLetter();
            }

            if(rightLetters.contains(guessedLetter) || wrongLetters.contains(guessedLetter)){
                System.out.println("You already tried this. Try a different letter.");
                return isCorrectLetter();
            }
            else{
                return guessedLetter;
            }
        }

        public void guessALetter(){
            String letterGuess = isCorrectLetter();

            if (movieToBeGuessed.contains(letterGuess)){
                System.out.println("Correct! You guessed the letter " + letterGuess + ". Keep it up.");
                rightLetters += letterGuess;
            }
            else{
                System.out.println("Wrong. There is no letter " + letterGuess + " in the hidden movie title.");
            chancesLeft--;
            wrongLetters +=" " + letterGuess;
            }

        }
        }
