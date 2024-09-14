package strategies;

import config.InputConfig;
import utility.DivisorSumFinder;
import utility.InputUtility;
import utility.OutputHandler;

import java.util.List;
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
        System.out.println("CURRENT MODE: FUNCTIONAL\n");
        Integer limit = InputUtility.getInputFunctional(scanner, config);
        System.out.println("You entered: " + limit);

        DivisorSumFinder finder = new DivisorSumFinder();
        List<Integer> numbersWithDivisorSum = finder.findNumbersWithDivisorSumFunctional(limit);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.outputNumbersFunctional(numbersWithDivisorSum);
    }
}