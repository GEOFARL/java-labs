package cli;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CliArgumentHandler {
    private final Map<String, String> namedArgs;
    private final Map<String, Set<String>> validOptions;

    public CliArgumentHandler(String[] args) {
        this.validOptions = new HashMap<>();
        this.namedArgs = new HashMap<>();
        parseArguments(args);
    }

    private void parseArguments(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("--")) {
                parseNamedArgument(arg);
            }
        }
    }

    private void parseNamedArgument(String arg) {
        String[] parts = arg.substring(2).split("=", 2);
        if (parts.length < 2) {
            return;
        }

        String key = parts[0];
        String value = parts[1];

        if (validOptions.containsKey(key) && !validOptions.get(key).contains(value)) {
            return;
        }

        namedArgs.put(key, value);
    }

    public void extendValidOptions(Map<String, Set<String>> additionalOptions) {
        additionalOptions.forEach((key, newValues) ->
                validOptions.merge(key, newValues, (existingValues, newValuesToAdd) -> {
                    existingValues.addAll(newValuesToAdd);
                    return existingValues;
                })
        );
    }

    public String getArgument(String key) {
        return namedArgs.get(key);
    }
}