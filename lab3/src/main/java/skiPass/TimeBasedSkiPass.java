package skiPass;

import java.time.LocalDate;

import enums.DayType;
import enums.PassDuration;

public class TimeBasedSkiPass extends SkiPass {
  private PassDuration duration;
  private LocalDate expiryDate;

  public TimeBasedSkiPass(DayType dayType, PassDuration duration, LocalDate expiryDate) {
    super(dayType);
    this.duration = duration;
    this.expiryDate = expiryDate;
  }

  @Override
  public boolean validateAccess() {
    if (blocked || LocalDate.now().isAfter(expiryDate)) {
      return false;
    }
    return true;
  }

  public PassDuration getDuration() {
    return duration;
  }
}
