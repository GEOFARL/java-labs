package cli;

public class CliArgumentHandler {
    private final String mode;

    public CliArgumentHandler(String[] args) {
        this.mode = parseArguments(args);
    }

    private String parseArguments(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <mode>");
            System.out.println("Modes: 'procedural' or 'functional'");
            return null;
        }

        String mode = args[0].toLowerCase();
        if (!"procedural".equals(mode) && !"functional".equals(mode)) {
            System.out.println("Invalid mode. Please use 'procedural' or 'functional'.");
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
