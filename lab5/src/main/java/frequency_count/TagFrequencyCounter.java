package frequency_count;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagFrequencyCounter {

  public Map<String, Integer> countHTMLTagsFrequency(BufferedReader reader) throws IOException {
    StringBuilder content = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      content.append(line);
    }
    reader.close();

    Pattern tagPattern = Pattern.compile("<\\s*(\\w+)[^>]*>");
    Matcher matcher = tagPattern.matcher(content.toString());
    Map<String, Integer> tagFrequency = new HashMap<>();
    while (matcher.find()) {
      String tag = matcher.group(1).toLowerCase();
      tagFrequency.put(tag, tagFrequency.getOrDefault(tag, 0) + 1);
    }

    return tagFrequency;
  }

  public void countHTMLTagsFrequencyFromURL(String stringURL) {
    try {
      URL url = new URL(stringURL);
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      Map<String, Integer> tagFrequency = countHTMLTagsFrequency(reader);
      printTagFrequency(tagFrequency);
    } catch (IOException e) {
      System.out.println("An error occurred while fetching or reading the URL: " + e.getMessage());
    }
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the URL of the website: ");
    String stringURL = scanner.nextLine();
    countHTMLTagsFrequencyFromURL(stringURL);
  }

  private void printTagFrequency(Map<String, Integer> tagFrequency) {
    System.out.println("Tags in lexicographical order:");
    tagFrequency.keySet().stream().sorted().forEach(tag -> System.out.println(tag + ": " + tagFrequency.get(tag)));

    System.out.println("\nTags by frequency:");
    tagFrequency.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
  }
}
