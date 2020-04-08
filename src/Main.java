public class Main {

    public static void main(String[] args) throws Exception {

        GuessTheMovie game = new GuessTheMovie("movies.txt");
        System.out.println("Welcome. The purpose of this game is to guess the name of the movie.");
        System.out.println("The name of the movie is now hidden. Guess the title by typing lower case letters.");
        System.out.println("You have 10 chances to guess the movie's name.");
        System.out.println("You will not lose chances when guessing correctly.");

        System.out.println("The movie title has " + game.getMovieTitle().length() + " characters (including spaces "
                + "and punctuation).");

        while(!game.endOfTheGame()){
            System.out.println("The hidden movie title:" + game.getHiddenMovieTitle());
            System.out.println("You guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:"
                    + game.getWrongLetters());
            game.guessALetter();
        }
        if(game.Victory()){
            System.out.println("You win!");
            System.out.println("You guessed " + game.getMovieTitle() + " correctly.");
        }
        else{
            System.out.println("You guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:" +
                    game.getWrongLetters());
            System.out.println("Game Over. You lost all your chances.");
            System.out.println("The movie title was " + game.getMovieTitle());
        }
    }
}