package cli;

import java.util.Set;

public class CliArgumentHandler {
    private final String mode;
    private final Set<String> validModes;

    public CliArgumentHandler(String[] args, Set<String> validModes) {
        this.validModes = validModes;
        this.mode = parseArguments(args);
    }

    private String parseArguments(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <mode>");
            System.out.println("Valid modes: " + String.join(", ", validModes));
            return null;
        }

        String mode = args[0].toLowerCase();
        if (!validModes.contains(mode)) {
            System.out.println("Invalid mode. Please use one of the following: " + String.join(", ", validModes));
            return null;
        }

        return mode;
    }

    public boolean isValid() {
        return mode != null;
    }

    public String getMode() {
        return mode;
    }
}
