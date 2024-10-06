package skiPass;

import enums.DayType;
import enums.LiftCountOption;

public class LiftCountSkiPass extends SkiPass {
  private int remainingLifts;

  public LiftCountSkiPass(DayType dayType, LiftCountOption liftCountOption) {
    super(dayType);
    this.remainingLifts = liftCountOption.getLifts();
  }

  @Override
  public boolean validateAccess() {
    if (blocked || remainingLifts <= 0) {
      return false;
    }
    if (remainingLifts != Integer.MAX_VALUE) {
      remainingLifts--;
    }
    return true;
  }

  public int getRemainingLifts() {
    return remainingLifts;
  }
}
