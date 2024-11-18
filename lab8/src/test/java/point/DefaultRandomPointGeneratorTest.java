package point;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultRandomPointGeneratorTest {

  @Test
  public void testGeneratePointWithinBounds() {
    DefaultRandomPointGenerator generator = new DefaultRandomPointGenerator();

    for (int i = 0; i < 1000; i++) {
      Point point = generator.generatePoint();
      assertTrue("X coordinate out of bounds", point.getX() >= 0 && point.getX() <= 1);
      assertTrue("Y coordinate out of bounds", point.getY() >= 0 && point.getY() <= 1);
    }
  }
}