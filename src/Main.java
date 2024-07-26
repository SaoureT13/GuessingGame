import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Hello, do you want to play Guessing Game (y/N) ?:   ");
        char answer = reader.next().toLowerCase().charAt(0);
        while (answer != 'n' && answer != 'y') {
            System.out.println("\nAnswer by 'y' or 'N");
            System.out.print("Do you want to play Guessing Game (y/N) ?:   ");
            answer = reader.next().toLowerCase().charAt(0);
        }

        while (answer == 'y') {
            guessingGame();

            System.out.print("\nDo you want to play again (y/N) ?:   ");
            answer = reader.next().charAt(0);
        }
        System.out.println("GoodBye");
    }

    static void guessingGame() {
        int randNum = (int) (Math.random() * 101);
        int numberTries = 10;
        boolean winner = false;


        while (numberTries > 0) {
            try {
                System.out.printf("\nYou have %d essaies\n", numberTries);
                System.out.print("Guess the number: ");
                Scanner input = new Scanner(System.in);
                int userTrial = input.nextInt();
                winner = evaluateGuess(randNum, userTrial);
                if (winner) {
                    break;
                }
                numberTries--;
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number");
            }
        }

        if (winner) {
            System.out.println("\nCongratulations, you guessed the number !!");
        } else {
            System.out.println("\nSorry, but you lost");
        }
    }

    static public boolean evaluateGuess(int winningNumber, int userTrial) {
        boolean winner = userTrial == winningNumber;
        if (userTrial > winningNumber) {
            System.out.println("The number is smaller");
        }
        if (userTrial < winningNumber) {
            System.out.println("The number is higher");
        }

        return winner;
    }
}