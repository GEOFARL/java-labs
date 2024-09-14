package cli.argumentProcessor;

import cli.CliArgumentHandler;

import java.util.Map;
import java.util.Set;

public class ModeArgumentProcessor implements ArgumentProcessor {
    private final Set<String> validModes = Set.of("procedural", "functional");
    public static final String modeKey = "mode";

    public ModeArgumentProcessor(CliArgumentHandler handler) {
        this.processArguments(handler);
    }

    @Override
    public void processArguments(CliArgumentHandler handler) {
        Map<String, Set<String>> validOptions = Map.of(modeKey, validModes);
        handler.extendValidOptions(validOptions);

        String mode = handler.getArgument(modeKey);
        if (mode == null) {
            throw new IllegalArgumentException("Mode argument is missing. Valid options are: " + validModes);
        }
    }
}
