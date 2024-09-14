package strategies;

import config.InputConfig;
import utility.DivisorSumFinder;
import utility.InputUtility;
import utility.OutputHandler;

import java.util.List;
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
        System.out.println("CURRENT MODE: PROCEDURAL\n");
        Integer limit = InputUtility.getInputProcedural(scanner, config);
        System.out.println("You entered: " + limit);

        DivisorSumFinder finder = new DivisorSumFinder();
        List<Integer> numbersWithDivisorSum = finder.findNumbersWithDivisorSumProcedural(limit);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.outputNumbersProcedural(numbersWithDivisorSum);
    }
}
