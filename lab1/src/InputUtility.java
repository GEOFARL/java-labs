import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtility {
    public static <T> T getInput(Scanner scanner, InputConfig<T> config) {
        T input = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(config.getPromptMessage());
            try {
                input = config.getInputSupplier().get();
                if (config.getValidator().test(input)) {
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
