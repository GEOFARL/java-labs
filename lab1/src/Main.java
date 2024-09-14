import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = getInput(scanner, scanner::nextInt, input -> true, "Please enter an integer: ");
        System.out.println("You entered: " + userInput);
    }

    public static <T> T getInput(Scanner scanner, Supplier<T> inputSupplier, Predicate<T> validator, String promptMessage) {
        T input = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(promptMessage);
            try {
                input = inputSupplier.get();
                if (validator.test(input)) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Does not meet the validation criteria.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }

        return input;
    }
}
