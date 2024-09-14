package strategies;

import config.InputConfig;
import utility.InputUtility;

import java.util.Scanner;

public class FunctionalModeStrategy implements ModeStrategy {

    private final Scanner scanner;
    private final InputConfig<Integer> config;

    public FunctionalModeStrategy(Scanner scanner, InputConfig<Integer> config) {
        this.scanner = scanner;
        this.config = config;
    }

    @Override
    public void execute() {
        Integer input = InputUtility.getInputFunctional(scanner, config);
        System.out.println("Functional mode: You entered " + input);
    }
}