import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;

    // Funktion för att utvärdera användarens gissning
    static boolean evaluateNumber(int guess, int target) {
        if (guess > target) {
            System.out.println("Your guess was too high!!");
        } else if (guess < target) {
            System.out.println("Your guess was too low!!");
        } else {
            System.out.println("You got it right!");
        }
        return guess == target;
    }

    // Funktion för att ta emot användarens gissning
    static boolean takeGuess(Scanner scanner, int target) {
        System.out.print("Please enter a number: ");
        String input = scanner.next();
        int guess = Integer.parseInt(input);
        return evaluateNumber(guess, target);
    }

    // Funktion för att fråga användaren om de vill spela igen
    static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String input = scanner.next().toLowerCase();
        return input.equals("yes");
    }

    // Huvudmetod för att köra spelet
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop för att spela spelet flera gånger om användaren vill
        do {
            playGame(scanner);
        } while (playAgain(scanner));

        System.out.println("Thanks for playing!");
    }

    // Funktion för att hantera huvudlogiken i spelet
    private static void playGame(Scanner scanner) {
        Random rand = new Random();
        int target = rand.nextInt(UPPER_BOUND + 1);
        int guessCount = 0;
        int bestGuessCount = 0;

        System.out.println("Guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND + "!");

        // Loop för att ta gissningar tills användaren gissar rätt nummer
        while (true) {
            boolean isRight = takeGuess(scanner, target);
            guessCount++;

            if (isRight) {
                printGuessResult(guessCount, bestGuessCount);
                guessCount = 0;
                target = rand.nextInt(UPPER_BOUND + 1);
                break;
            }
        }
    }

    // Funktion för att skriva ut resultatet av en omgång
    private static void printGuessResult(int guessCount, int bestGuessCount) {
        String endString = (guessCount == 1) ? " guess." : " guesses.";
        System.out.println("Great job! New number has now been randomized. It took you " + guessCount + endString);

        if (guessCount < bestGuessCount) { // Lagt till en scoreboard
            if (bestGuessCount != 0) {
                System.out.println("You have beaten your previous record that was " + bestGuessCount);
            }
            bestGuessCount = guessCount;
        } else if (bestGuessCount != 0) {
            System.out.println("Your record is still " + bestGuessCount);
        }
    }
}
/*
    //Ask the user to input a number and then use eval number to compare it and return that
    static boolean guess(Scanner scanner, int luckyNum) {
        System.out.print("Please enter a number: ");
        String input = scanner.next();
        int num = Integer.parseInt(input);
        return evalNum(num, luckyNum);
    }

    public static void main(String[] args) {
        //Variable declarations
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int luckyNum = rand.nextInt(101) ;
        int guessCount = 0;
        int bestGuessCount = 0;
        System.out.println("Guess a number between 0 and 100!");
        while (true) {
            boolean isRight = guess(scanner, luckyNum);
            guessCount++;
            if (isRight) {
                //Reset the code
                String endString = " guesses.";
                if (guessCount == 1) {
                    endString = " guess.";
                }
                System.out.println("Great job! New number has now been randomized. It took you " + guessCount + endString);
                if (guessCount < bestGuessCount) {
                    if (bestGuessCount != 0) {
                        System.out.println("You have beat your previous record that was " + bestGuessCount);
                    }
                    bestGuessCount = guessCount;

                } else if (bestGuessCount != 0) {
                    System.out.println("Your record is still " + bestGuessCount);
                }
                guessCount = 0;
                luckyNum = rand.nextInt(101);
            }
        }
    }
}
*/