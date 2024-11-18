package point;

public class Point {
  private final double x;
  private final double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public boolean isInsideCircle() {
    return x * x + y * y <= 1.0;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

}
