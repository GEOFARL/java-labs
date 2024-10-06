package skiPass;

import java.util.UUID;

import enums.DayType;

public abstract class SkiPass {
  protected String id;
  protected DayType dayType;
  protected boolean blocked;

  public SkiPass(DayType dayType) {
    this.id = UUID.randomUUID().toString();
    this.dayType = dayType;
    this.blocked = false;
  }

  public String getId() {
    return id;
  }

  public DayType getDayType() {
    return dayType;
  }

  public boolean isBlocked() {
    return blocked;
  }

  public void block() {
    blocked = true;
  }

  public abstract boolean validateAccess();
}
