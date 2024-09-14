import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputConfig<Integer> inputConfig = new InputConfig.Builder<Integer>()
                .withInputSupplier(scanner::nextInt)
                .withValidator(input -> input > 1)
                .withPromptMessage("Please enter an integer greater than 1: ")
                .build();

        int userInput = InputUtility.getInput(scanner, inputConfig);

        System.out.println("You entered: " + userInput);
    }
}
