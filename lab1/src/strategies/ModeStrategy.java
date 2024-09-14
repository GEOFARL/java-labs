package strategies;

import config.InputConfig;

import java.util.Scanner;

public interface ModeStrategy {
    <T> T getInput(Scanner scanner, InputConfig<T> config);
    String getModeName();
}
