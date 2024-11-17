package console;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ConsoleHandlerTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream printStream = new PrintStream(outContent);

  private final ByteArrayInputStream inContent = new ByteArrayInputStream("Test input\n".getBytes());
  private final InputStream originalIn = System.in;

  private ConsoleHandler consoleHandler;

  @Before
  public void setUp() {
    System.setOut(printStream); // Redirect System.out to capture output
    System.setIn(inContent); // Redirect System.in to provide input
    consoleHandler = new ConsoleHandler();
  }

  @After
  public void tearDown() {
    System.setOut(originalOut); // Restore original System.out
    System.setIn(originalIn); // Restore original System.in
  }

  @Test
  public void testReadLine() {
    String input = consoleHandler.readLine("Enter something: ");
    assertEquals("Test input", input); // Verify the captured input
  }

  @Test
  public void testPrint() {
    consoleHandler.print("Hello, World!");
    assertTrue(outContent.toString().contains("Hello, World!")); // Verify the captured output
  }
}