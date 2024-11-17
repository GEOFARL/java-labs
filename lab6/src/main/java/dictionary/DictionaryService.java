package dictionary;

public interface DictionaryService {
  void addWord(String sourceWord, String targetWord);

  String translate(String phrase);
}