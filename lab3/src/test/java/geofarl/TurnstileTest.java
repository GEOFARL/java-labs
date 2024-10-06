package geofarl;

import enums.DayType;
import skiPass.SkiPass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TurnstileTest {

  private Turnstile turnstile;
  private SkiPass validSkiPass;
  private SkiPass invalidSkiPass;

  @Before
  public void setUp() {
    turnstile = new Turnstile();

    validSkiPass = Mockito.mock(SkiPass.class);
    when(validSkiPass.validateAccess()).thenReturn(true);
    when(validSkiPass.getDayType()).thenReturn(DayType.WORKDAY);

    invalidSkiPass = Mockito.mock(SkiPass.class);
    when(invalidSkiPass.validateAccess()).thenReturn(false);
    when(invalidSkiPass.getDayType()).thenReturn(DayType.WEEKEND);
  }

  @Test
  public void testProcessPass_Success() {
    turnstile.processPass(validSkiPass);

    assertEquals(1, turnstile.getSuccessfulPasses());
    assertEquals(0, turnstile.getDeniedPasses());

    Map<DayType, Integer> passesByType = turnstile.getPassedByType();
    assertEquals(1, (int) passesByType.get(DayType.WORKDAY));
  }

  @Test
  public void testProcessPass_Failure() {
    turnstile.processPass(invalidSkiPass);

    assertEquals(0, turnstile.getSuccessfulPasses());
    assertEquals(1, turnstile.getDeniedPasses());

    Map<DayType, Integer> passesByType = turnstile.getPassedByType();
    assertEquals(null, passesByType.get(DayType.WEEKEND));
  }

  @Test
  public void testMultiplePasses() {
    for (int i = 0; i < 3; i++) {
      turnstile.processPass(validSkiPass);
    }
    for (int i = 0; i < 2; i++) {
      turnstile.processPass(invalidSkiPass);
    }

    assertEquals(3, turnstile.getSuccessfulPasses());
    assertEquals(2, turnstile.getDeniedPasses());

    Map<DayType, Integer> passesByType = turnstile.getPassedByType();
    assertEquals(3, (int) passesByType.get(DayType.WORKDAY));
  }

  @Test
  public void testPrintSummary() {
    turnstile.processPass(validSkiPass);
    turnstile.processPass(invalidSkiPass);

    assertEquals(1, turnstile.getSuccessfulPasses());
    assertEquals(1, turnstile.getDeniedPasses());
  }

  @Test
  public void testPrintBreakdownByType() {
    SkiPass weekendPass = Mockito.mock(SkiPass.class);
    when(weekendPass.validateAccess()).thenReturn(true);
    when(weekendPass.getDayType()).thenReturn(DayType.WEEKEND);

    turnstile.processPass(validSkiPass);
    turnstile.processPass(weekendPass);

    Map<DayType, Integer> passesByType = turnstile.getPassedByType();
    assertEquals(1, (int) passesByType.get(DayType.WORKDAY));
    assertEquals(1, (int) passesByType.get(DayType.WEEKEND));
  }
}
