package point;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

  @Test
  public void testPointInsideCircle() {
    Point point = new Point(0.5, 0.5);
    assertTrue(point.isInsideCircle());
  }

  @Test
  public void testPointOnCircleBoundary() {
    Point point = new Point(1.0, 0.0);
    assertTrue(point.isInsideCircle());
  }

  @Test
  public void testPointOutsideCircle() {
    Point point = new Point(1.1, 1.1);
    assertFalse(point.isInsideCircle());
  }
}
