package frequency_count;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TagFrequencyCounterTest {

  private TagFrequencyCounter tagFrequencyCounter;

  @Before
  public void setUp() {
    tagFrequencyCounter = new TagFrequencyCounter();
  }

  @Test
  public void testCountHTMLTagsFrequency() throws IOException {
    String htmlContent = "<html><body><div><div><p>Hello</p></div></div></body></html>";
    BufferedReader reader = new BufferedReader(new StringReader(htmlContent));

    Map<String, Integer> tagFrequency = tagFrequencyCounter.countHTMLTagsFrequency(reader);

    assertEquals(1, (int) tagFrequency.get("html"));
    assertEquals(1, (int) tagFrequency.get("body"));
    assertEquals(2, (int) tagFrequency.get("div"));
    assertEquals(1, (int) tagFrequency.get("p"));
  }

  @Test
  public void testCountHTMLTagsFrequency_EmptyDocument() throws IOException {
    String htmlContent = "";

    BufferedReader reader = new BufferedReader(new StringReader(htmlContent));

    Map<String, Integer> tagFrequency = tagFrequencyCounter.countHTMLTagsFrequency(reader);

    assertEquals(0, tagFrequency.size());
  }

  @Test(expected = IOException.class)
  public void testCountHTMLTagsFrequency_IOException() throws IOException {
    BufferedReader reader = mock(BufferedReader.class);
    when(reader.readLine()).thenThrow(new IOException("Simulated I/O Exception"));

    tagFrequencyCounter.countHTMLTagsFrequency(reader);
  }
}
