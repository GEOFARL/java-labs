package utility;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class DivisorSumFinderTest {
    @Test
    public void testFindNumbersWithDivisorSumProcedural() {
        DivisorSumFinder finder = new DivisorSumFinder();
        List<Integer> result = finder.findNumbersWithDivisorSumProcedural(100);

        assertTrue(result.contains(6));
        assertTrue(result.contains(28));
        assertFalse(result.contains(10));

        assertEquals(2, result.size());
    }

    @Test
    public void testFindNumbersWithDivisorSumFunctional() {
        DivisorSumFinder finder = new DivisorSumFinder();
        List<Integer> result = finder.findNumbersWithDivisorSumFunctional(100);

        assertTrue(result.contains(6));
        assertTrue(result.contains(28));
        assertFalse(result.contains(10));
        assertEquals(2, result.size());
    }
}