package task;

import java.util.concurrent.atomic.AtomicLong;

import point.Point;
import point.PointGenerator;

public class MonteCarloTask implements Runnable {
  private final AtomicLong insideCircleCount;
  private final long iterations;
  private final PointGenerator pointGenerator;

  public MonteCarloTask(AtomicLong insideCircleCount, long iterations, PointGenerator pointGenerator) {
    this.insideCircleCount = insideCircleCount;
    this.iterations = iterations;
    this.pointGenerator = pointGenerator;
  }

  @Override
  public void run() {
    long localInsideCircle = 0;

    for (long i = 0; i < iterations; i++) {
      Point point = pointGenerator.generatePoint();
      if (point.isInsideCircle()) {
        localInsideCircle++;
      }
    }

    insideCircleCount.addAndGet(localInsideCircle);
  }
}
