package strategies;

import cli.CliArgumentHandler;
import cli.argumentProcessor.ModeArgumentProcessor;
import config.InputConfig;

import java.util.Scanner;

public class ModeStrategyResolver {

    public static ModeStrategy resolve(CliArgumentHandler handler) {
        String mode = handler.getArgument(ModeArgumentProcessor.modeKey);

        Scanner scanner = new Scanner(System.in);
        InputConfig<Integer> inputConfig = new InputConfig.Builder<Integer>()
                .withInputSupplier(scanner::nextInt)
                .withValidator(input -> input > 1)
                .withPromptMessage("Please enter the upper limit: ")
                .build();

        return switch (mode.toLowerCase()) {
            case "procedural" -> new ProceduralModeStrategy(scanner, inputConfig);
            case "functional" -> new FunctionalModeStrategy(scanner, inputConfig);
            default -> throw new IllegalArgumentException("Unsupported mode: " + mode);
        };
    }
}