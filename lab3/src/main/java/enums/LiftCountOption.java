package enums;

public enum LiftCountOption {
  LIFT_10(10),
  LIFT_20(20),
  LIFT_50(50),
  LIFT_100(100),
  UNLIMITED(Integer.MAX_VALUE);

  private final int lifts;

  LiftCountOption(int lifts) {
    this.lifts = lifts;
  }

  public int getLifts() {
    return lifts;
  }
}
