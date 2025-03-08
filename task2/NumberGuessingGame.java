import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int guess, attempts = 0;
        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");
        // Loop until the user guesses correctly
        do {
            System.out.print("Enter your guess: ");
            while (!scanner.hasNextInt()) { // Input validation
                System.out.print("Invalid input! Please enter a number: ");
                scanner.next();
            }
            guess = scanner.nextInt();
            attempts++;
            if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        } while (guess != randomNumber);
        scanner.close();
    }
}
