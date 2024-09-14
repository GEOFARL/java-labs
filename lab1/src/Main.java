import cli.CliArgumentHandler;
import config.InputConfig;
import strategies.ModeStrategy;
import cli.ModeStrategyResolver;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Set<String>> validOptions = Map.of(
                "mode", Set.of("procedural", "functional")
        );
        CliArgumentHandler argumentHandler = new CliArgumentHandler(args, validOptions);

        String mode = argumentHandler.getArgument("mode");
        if (mode == null) {
            System.out.println("Usage: --mode=procedural or --mode=functional");
            return;
        }

        ModeStrategy strategy = ModeStrategyResolver.resolve(mode);
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
