package estimator;

import java.util.concurrent.atomic.AtomicLong;

import point.PointGenerator;
import task.MonteCarloTask;

public class MonteCarloPiEstimator {
  private final int numThreads;
  private final long totalIterations;
  private final PointGenerator pointGenerator;

  public MonteCarloPiEstimator(int numThreads, long totalIterations, PointGenerator pointGenerator) {
    this.numThreads = numThreads;
    this.totalIterations = totalIterations;
    this.pointGenerator = pointGenerator;
  }

  public double estimatePi() {
    AtomicLong insideCircleCount = new AtomicLong(0);
    long iterationsPerThread = totalIterations / numThreads;

    Thread[] threads = new Thread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      threads[i] = new Thread(new MonteCarloTask(insideCircleCount, iterationsPerThread, pointGenerator));
      threads[i].start();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return 4.0 * insideCircleCount.get() / totalIterations;
  }
}