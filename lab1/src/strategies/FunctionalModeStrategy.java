package strategies;

import config.InputConfig;
import utility.InputUtility;

import java.util.Scanner;

public class FunctionalModeStrategy implements ModeStrategy {

    @Override
    public <T> T getInput(Scanner scanner, InputConfig<T> config) {
        return InputUtility.getInputFunctional(scanner, config);
    }

    @Override
    public String getModeName() {
        return "Functional";
    }
}