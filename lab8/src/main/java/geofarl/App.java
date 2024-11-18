package geofarl;

import estimator.MonteCarloPiEstimator;
import point.DefaultRandomPointGenerator;
// mvn exec:java-Dexec.mainClass="geofarl.App"-Dexec.args="8"

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ParallelMonteCarloPi <number_of_threads>");
            return;
        }

        int numThreads = Integer.parseInt(args[0]);
        long totalIterations = 1_000_000_000L;

        MonteCarloPiEstimator estimator = new MonteCarloPiEstimator(
                numThreads,
                totalIterations,
                new DefaultRandomPointGenerator());

        long startTime = System.nanoTime();
        double pi = estimator.estimatePi();
        long endTime = System.nanoTime();

        double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;

        System.out.printf("PI is %.5f%n", pi);
        System.out.printf("THREADS %d%n", numThreads);
        System.out.printf("ITERATIONS %,d%n", totalIterations);
        System.out.printf("TIME %.2fms%n", elapsedTimeMs);
    }
}
