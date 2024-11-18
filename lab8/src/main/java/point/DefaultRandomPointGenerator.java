package point;

import java.util.Random;

public class DefaultRandomPointGenerator implements PointGenerator {
  private final Random random;

  public DefaultRandomPointGenerator() {
    this.random = new Random();
  }

  @Override
  public Point generatePoint() {
    return new Point(random.nextDouble(), random.nextDouble());
  }
}
