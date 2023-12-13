import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ":");

            while (attempts < maxAttempts) {
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                }
            }

            rounds++;

            System.out.println("\nDo you want to play again? (1 for Yes, 0 for No):");
        } while (scanner.nextInt() == 1);

        System.out.println("Thanks for playing! Your total score is: " + (rounds - totalAttempts));
        scanner.close();
    }
}