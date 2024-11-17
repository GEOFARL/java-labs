package app;

import org.junit.Before;
import org.junit.Test;

import console.ConsoleHandler;
import dictionary.DictionaryService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TranslatorApplicationTest {
  private DictionaryService mockDictionaryService;
  private ConsoleHandler mockConsoleHandler;
  private TranslatorApplication translatorApplication;

  @Before
  public void setUp() {
    mockDictionaryService = mock(DictionaryService.class);
    mockConsoleHandler = mock(ConsoleHandler.class);
    translatorApplication = new TranslatorApplication(mockDictionaryService, mockConsoleHandler);
  }

  @Test
  public void testStart() {
    // Simulate user interactions
    when(mockConsoleHandler.readLine("Enter an English word: "))
        .thenReturn("hello", "world", "exit");
    when(mockConsoleHandler.readLine("Enter its Ukrainian translation: "))
        .thenReturn("привіт", "світ");
    when(mockConsoleHandler.readLine("> "))
        .thenReturn("hello world");

    translatorApplication.start();

    verify(mockDictionaryService).addWord("hello", "привіт");
    verify(mockDictionaryService).addWord("world", "світ");
    verify(mockDictionaryService).translate("hello world");

    verify(mockConsoleHandler, times(6)).print(anyString());
  }
}