import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = getIntegerInput(scanner);
        System.out.println("You entered: " + userInput);
    }

    public static int getIntegerInput(Scanner scanner) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter an integer: ");
            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }

        return input;
    }
}
