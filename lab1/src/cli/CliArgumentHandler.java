package cli;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CliArgumentHandler {
    private final Map<String, String> namedArgs;
    private final Map<String, Boolean> flags;
    private final Map<String, Set<String>> validOptions;

    public CliArgumentHandler(String[] args) {
        this.validOptions = new HashMap<>();
        this.namedArgs = new HashMap<>();
        this.flags = new HashMap<>();
        parseArguments(args);
    }

    private void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("--")) {
                String[] parts = arg.substring(2).split("=", 2);
                if (parts.length > 1) {
                    if (validOptions.containsKey(parts[0]) && !validOptions.get(parts[0]).contains(parts[1])) {
                        System.out.println("Invalid value for " + parts[0] + ". Valid options are: " + validOptions.get(parts[0]));
                        continue;
                    }
                    namedArgs.put(parts[0], parts[1]);
                } else {
                    flags.put(parts[0], true);
                }
            } else {
                namedArgs.put("positional_" + i, arg);
            }
        }
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

    public boolean getFlag(String flag) {
        return flags.getOrDefault(flag, false);
    }
}
