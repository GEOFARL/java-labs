package dictionary;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnglishToUkrainianDictionaryTest {
  private EnglishToUkrainianDictionary dictionary;

  @Before
  public void setUp() {
    dictionary = new EnglishToUkrainianDictionary();
  }

  @Test
  public void testAddWordAndTranslate() {
    dictionary.addWord("hello", "привіт");
    dictionary.addWord("world", "світ");

    String translation = dictionary.translate("hello world");
    assertEquals("привіт світ", translation);
  }

  @Test
  public void testTranslateWithUnknownWord() {
    dictionary.addWord("hello", "привіт");

    String translation = dictionary.translate("hello friend");
    assertEquals("привіт friend", translation); // Unknown word should remain unchanged.
  }

  @Test
  public void testEmptyPhrase() {
    String translation = dictionary.translate("");
    assertEquals("", translation); // Empty phrase should return an empty string.
  }
}