package geofarl;

import java.util.HashMap;
import java.util.Map;

import enums.DayType;
import skiPass.SkiPass;

public class Turnstile {
  private int successfulPasses;
  private int deniedPasses;
  private Map<DayType, Integer> passedByType;

  public Turnstile() {
    this.successfulPasses = 0;
    this.deniedPasses = 0;
    this.passedByType = new HashMap<>();
  }

  public void processPass(SkiPass skiPass) {
    if (skiPass.validateAccess()) {
      successfulPasses++;
      passedByType.put(skiPass.getDayType(), passedByType.getOrDefault(skiPass.getDayType(), 0) + 1);
      System.out.println("Access granted");
    } else {
      deniedPasses++;
      System.out.println("Access denied");
    }
  }

  public int getSuccessfulPasses() {
    return successfulPasses;
  }

  public int getDeniedPasses() {
    return deniedPasses;
  }

  public Map<DayType, Integer> getPassedByType() {
    return passedByType;
  }

  public void printSummary() {
    System.out.println("Summary:");
    System.out.println("Successful passes: " + successfulPasses);
    System.out.println("Denied passes: " + deniedPasses);
  }

  public void printBreakdownByType() {
    System.out.println("Breakdown by ski-pass type:");
    for (Map.Entry<DayType, Integer> entry : passedByType.entrySet()) {
      System.out.println("Ski-pass type (" + entry.getKey() + "): " + entry.getValue() + " passes");
    }
  }
}
