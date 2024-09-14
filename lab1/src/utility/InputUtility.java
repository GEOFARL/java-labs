package utility;

import config.InputConfig;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class InputUtility {
    public static <T> T getInputProcedural(Scanner scanner, InputConfig<T> config) {
        T input = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(config.getPromptMessage());
            try {
                input = config.getInputSupplier().get();
                if (config.getValidator().test(input)) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }

        return input;
    }

    public static <T> T getInputFunctional(Scanner scanner, InputConfig<T> config) {
        return Optional.ofNullable(promptForInput(scanner, config))
                .orElseGet(() -> getInputFunctional(scanner, config));
    }

    private static <T> T promptForInput(Scanner scanner, InputConfig<T> config) {
        System.out.print(config.getPromptMessage());

        try {
            return Optional.of(config.getInputSupplier().get())
                    .filter(config.getValidator())
                    .orElse(null);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
            return null;
        }
    }
}
