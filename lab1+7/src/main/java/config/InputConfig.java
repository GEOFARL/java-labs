package config;

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

    public static class Builder<T> {
        private Supplier<T> inputSupplier;
        private  Predicate<T> validator = _ -> true;
        private String promptMessage = "Enter input: ";

        public Builder<T> withInputSupplier(Supplier<T> inputSupplier) {
            this.inputSupplier = inputSupplier;
            return this;
        }

        public Builder<T> withValidator(Predicate<T> validator) {
            this.validator = validator;
            return this;
        }

        public Builder<T> withPromptMessage(String promptMessage) {
            this.promptMessage = promptMessage;
            return this;
        }

        public InputConfig<T> build() {
            return new InputConfig<>(inputSupplier, validator, promptMessage);
        }
    }
}
