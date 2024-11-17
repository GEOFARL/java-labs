package app;

import console.ConsoleHandler;
import dictionary.DictionaryService;

public class TranslatorApplication {
  private final DictionaryService dictionaryService;
  private final ConsoleHandler consoleHandler;

  public TranslatorApplication(DictionaryService dictionaryService, ConsoleHandler consoleHandler) {
    this.dictionaryService = dictionaryService;
    this.consoleHandler = consoleHandler;
  }

  public void start() {
    consoleHandler.print("Welcome to the Translator Application!");
    consoleHandler.print("Add words to the dictionary (type 'exit' to stop adding words).");

    while (true) {
      String sourceWord = consoleHandler.readLine("Enter an English word: ");
      if ("exit".equalsIgnoreCase(sourceWord))
        break;

      String targetWord = consoleHandler.readLine("Enter its Ukrainian translation: ");
      dictionaryService.addWord(sourceWord, targetWord);
      consoleHandler.print("Word added to the dictionary!");
    }

    consoleHandler.print("\nEnter an English phrase to translate:");
    String phrase = consoleHandler.readLine("> ");
    String translation = dictionaryService.translate(phrase);

    consoleHandler.print("\nTranslation: " + translation);
  }
}