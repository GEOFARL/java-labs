import cli.CliArgumentHandler;
import cli.argumentProcessor.ModeArgumentProcessor;
import strategies.ModeStrategyResolver;

public class Main {
    public static void main(String[] args) {
        CliArgumentHandler argumentHandler = new CliArgumentHandler(args);

        try {
            new ModeArgumentProcessor(argumentHandler);
            ModeStrategyResolver.resolve(argumentHandler).execute();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
