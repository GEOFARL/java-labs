package cli;

import strategies.FunctionalModeStrategy;
import strategies.ModeStrategy;
import strategies.ProceduralModeStrategy;

public class ModeStrategyResolver {

    public static ModeStrategy resolve(String mode) {
        return switch (mode.toLowerCase()) {
            case "procedural" -> new ProceduralModeStrategy();
            case "functional" -> new FunctionalModeStrategy();
            default -> throw new IllegalArgumentException("Unsupported mode: " + mode);
        };
    }
}