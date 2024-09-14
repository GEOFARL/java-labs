package strategies;

import config.InputConfig;
import utility.InputUtility;

import java.util.Scanner;

public class ProceduralModeStrategy implements ModeStrategy {
    private final Scanner scanner;
    private final InputConfig<Integer> config;

    public ProceduralModeStrategy(Scanner scanner, InputConfig<Integer> config) {
        this.scanner = scanner;
        this.config = config;
    }

    @Override
    public void execute() {
        Integer input = InputUtility.getInputProcedural(scanner, config);
        System.out.println("Procedural mode: You entered " + input);
    }
}
