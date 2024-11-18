package geofarl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import estimator.MonteCarloPiEstimator;
import point.DefaultRandomPointGenerator;

public class AppTest {
    @Test
    public void testEndToEndWithSmallIterations() {
        int numThreads = 4;
        long totalIterations = 1000;

        MonteCarloPiEstimator estimator = new MonteCarloPiEstimator(
                numThreads,
                totalIterations,
                new DefaultRandomPointGenerator());

        double pi = estimator.estimatePi();

        assertTrue("PI should be approximately correct", pi > 3.0 && pi < 3.2);
    }
}
