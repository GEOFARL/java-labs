package console;

import java.util.Scanner;

public class ConsoleHandler {
  private final Scanner scanner;

  public ConsoleHandler() {
    this.scanner = new Scanner(System.in);
  }

  public String readLine(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public void print(String message) {
    System.out.println(message);
  }

  public void close() {
    scanner.close();
  }
}
