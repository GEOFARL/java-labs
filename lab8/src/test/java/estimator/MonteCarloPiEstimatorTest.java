package estimator;

import org.junit.Test;

import point.Point;
import point.PointGenerator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MonteCarloPiEstimatorTest {

  @Test
  public void testEstimatePiWithMockedPointGenerator() {
    PointGenerator mockGenerator = mock(PointGenerator.class);
    when(mockGenerator.generatePoint())
        .thenReturn(new Point(0.5, 0.5))
        .thenReturn(new Point(1.5, 1.5));

    MonteCarloPiEstimator estimator = new MonteCarloPiEstimator(2, 4, mockGenerator);
    double pi = estimator.estimatePi();

    assertEquals(1.0, pi, 0.1);
  }
}