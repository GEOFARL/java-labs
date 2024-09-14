import cli.CliArgumentHandler;
import config.InputConfig;
import strategies.ModeStrategy;
import cli.ModeStrategyResolver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       CliArgumentHandler argumentHandler = new CliArgumentHandler(args);

       if (!argumentHandler.isValid()) {
           return;
       }

        ModeStrategy strategy = ModeStrategyResolver.resolve(argumentHandler.getMode());
        Scanner scanner = new Scanner(System.in);
        InputConfig<Integer> inputConfig = new InputConfig.Builder<Integer>()
                .withInputSupplier(scanner::nextInt)
                .withValidator(input -> input > 1)
                .withPromptMessage("Please enter an integer greater than 1: ")
                .build();

        int userInput = strategy.getInput(scanner, inputConfig);
        System.out.println(strategy.getModeName() + ": You entered: " + userInput);
    }
}
