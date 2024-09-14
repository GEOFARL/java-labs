import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <mode>");
            System.out.println("Modes: 'procedural' or 'functional'");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String mode = args[0];

        InputConfig<Integer> inputConfig = new InputConfig.Builder<Integer>()
                .withInputSupplier(scanner::nextInt)
                .withValidator(input -> input > 1)
                .withPromptMessage("Please enter an integer greater than 1: ")
                .build();

        if ("procedural".equalsIgnoreCase(mode)) {
            int userInput = InputUtility.getInputProcedural(scanner, inputConfig);
            System.out.println("Procedural: You entered: " + userInput);
        } else if ("functional".equalsIgnoreCase(mode)) {
            int userInput = InputUtility.getInputFunctional(scanner, inputConfig);
            System.out.println("Functional: You entered: " + userInput);
        } else {
            System.out.println("Invalid mode. Please use 'procedural' or 'functional'.");
        }
    }
}
