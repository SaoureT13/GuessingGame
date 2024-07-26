import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
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

    static public void guessingGame() {
        int randNum = (int) (Math.random() * 101);
        boolean winner = false;
        int numberTries = 2;
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.printf("\nYou have %d essaies\n", numberTries);
            System.out.print("Guess the number: ");
            int essaie = reader.nextInt();

            if (essaie == randNum) {
                winner = true;
                break;
            }
            numberTries--;
            if (numberTries == 0) break;

            if (essaie > randNum) {
                System.out.println("The number is smaller");
            }
            if (essaie < randNum) {
                System.out.println("The number is higher");
            }
        }
        if (winner) {
            System.out.println("Congratulations, you guessed it number");
        } else {
            System.out.println("Sorry, you lost");
        }
    }
}