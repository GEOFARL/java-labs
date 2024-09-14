package utility;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {
    public void outputNumbersProcedural(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("No numbers to output.");
            return;
        }

        StringBuilder result = new StringBuilder("\nThe numbers whose divisors sum up to themselves are:\n");
        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                result.append(", ");
            }
        }

        System.out.println(result.toString());
    }

    public void outputNumbersFunctional(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("No numbers to output.");
            return;
        }

        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("\nThe numbers whose divisors sum up to themselves are:\n" + result);
    }
}
