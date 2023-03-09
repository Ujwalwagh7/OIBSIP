import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        int round = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Number! You have " + maxAttempts + " attempts per round.");

        while (true) {
            Random random = new Random();
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsLeft = maxAttempts;

            System.out.println("\nRound " + round + ": Guess the number between " + minRange + " and " + maxRange);

            while (attemptsLeft > 0) {
                System.out.print("Attempts left: " + attemptsLeft + ". Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Correct! The number was " + randomNumber + ".");
                    score += attemptsLeft;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                attemptsLeft--;
            }

            if (attemptsLeft == 0) {
                System.out.println("Sorry, you have run out of attempts. The number was " + randomNumber + ".");
            }

            round++;

            System.out.print("Your score is " + score + ". Do you want to play again? (y/n) ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing! Your final score is " + score + ".");
                break;
            }
        }

        scanner.close();
    }
}