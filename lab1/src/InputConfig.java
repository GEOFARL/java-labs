import java.util.function.Predicate;
import java.util.function.Supplier;

public class InputConfig<T> {
    private Supplier<T> inputSupplier;
    private Predicate<T> validator;
    private String promptMessage;

    public InputConfig(Supplier<T> inputSupplier, Predicate<T> validator, String promptMessage) {
        this.inputSupplier = inputSupplier;
        this.validator = validator;
        this.promptMessage = promptMessage;
    }

    public Supplier<T> getInputSupplier() {
        return inputSupplier;
    }

    public Predicate<T> getValidator() {
        return validator;
    }

    public String getPromptMessage() {
        return promptMessage;
    }
}
