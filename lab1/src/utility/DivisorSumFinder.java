package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DivisorSumFinder {
    public List<Integer> findNumbersWithDivisorSumProcedural(int limit) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            if (isDivisorSumEqualToNumberProcedural(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findNumbersWithDivisorSumFunctional(int limit) {
        return IntStream.rangeClosed(1, limit)
                .filter(this::isDivisorSumEqualToNumberFunctional)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isDivisorSumEqualToNumberProcedural(int number) {
        int sumOfDivisors = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        return sumOfDivisors == number;
    }

    private boolean isDivisorSumEqualToNumberFunctional(int number) {
        int sumOfDivisors = IntStream.rangeClosed(1, number / 2)
                .filter(divisor -> number % divisor == 0)
                .sum();

        return sumOfDivisors == number;
    }
}
