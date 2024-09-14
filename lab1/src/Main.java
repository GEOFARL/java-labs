import cli.CliArgumentHandler;
import config.InputConfig;
import strategies.ModeStrategy;
import cli.ModeStrategyResolver;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> validModes = Set.of("procedural", "functional");
        CliArgumentHandler argumentHandler = new CliArgumentHandler(args, validModes);

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
