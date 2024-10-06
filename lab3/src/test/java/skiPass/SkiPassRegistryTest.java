package skiPass;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SkiPassRegistryTest {

  private SkiPassRegistry registry;
  private SkiPass mockSkiPass;

  @Before
  public void setUp() {
    registry = new SkiPassRegistry();

    mockSkiPass = Mockito.mock(SkiPass.class);
    when(mockSkiPass.getId()).thenReturn("1234");
  }

  @Test
  public void testIssueSkiPass() {
    SkiPass issuedSkiPass = registry.issueSkiPass(mockSkiPass);

    assertEquals("1234", issuedSkiPass.getId());
    assertSame(mockSkiPass, registry.getSkiPass("1234"));
  }

  @Test
  public void testBlockSkiPass() {
    registry.issueSkiPass(mockSkiPass);
    registry.blockSkiPass("1234");

    verify(mockSkiPass, times(1)).block();
  }

  @Test
  public void testGetSkiPass() {
    registry.issueSkiPass(mockSkiPass);

    SkiPass retrievedSkiPass = registry.getSkiPass("1234");
    assertNotNull(retrievedSkiPass);
    assertSame(mockSkiPass, retrievedSkiPass);
  }

  @Test
  public void testBlockNonexistentSkiPass() {
    registry.blockSkiPass("9999");

    verify(mockSkiPass, never()).block();
  }

  @Test
  public void testGetNonexistentSkiPass() {
    SkiPass nonExistentSkiPass = registry.getSkiPass("9999");

    assertNull(nonExistentSkiPass);
  }
}
