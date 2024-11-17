package dictionary;

import java.util.HashMap;
import java.util.Map;

public class EnglishToUkrainianDictionary implements DictionaryService {
  private final Map<String, String> dictionary;

  public EnglishToUkrainianDictionary() {
    this.dictionary = new HashMap<>();
  }

  @Override
  public void addWord(String sourceWord, String targetWord) {
    dictionary.put(sourceWord.toLowerCase(), targetWord.toLowerCase());
  }

  @Override
  public String translate(String phrase) {
    String[] words = phrase.toLowerCase().split(" ");
    StringBuilder translation = new StringBuilder();

    for (String word : words) {
      translation.append(dictionary.getOrDefault(word, word)).append(" ");
    }

    return translation.toString().trim();
  }
}