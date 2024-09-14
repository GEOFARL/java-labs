package strategies;

import config.InputConfig;
import utility.InputUtility;

import java.util.Scanner;

public class ProceduralModeStrategy implements ModeStrategy {
    @Override
    public <T> T getInput(Scanner scanner, InputConfig<T> config) {
        return InputUtility.getInputProcedural(scanner, config);
    }

    @Override
    public String getModeName() {
        return "Procedural";
    }
}
