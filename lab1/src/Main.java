import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputConfig<Integer> inputConfig = new InputConfig<>(
                scanner::nextInt,
                input -> input > 1,
                "Please enter an integer greater than 1: "
        );

        int userInput = InputUtility.getInput(scanner, inputConfig);

        System.out.println("You entered: " + userInput);
    }
}
