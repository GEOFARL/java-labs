package tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
  private List<Task> tasks = new ArrayList<>();
  private Scanner scanner;

  public TaskManager() {
    this.scanner = new Scanner(System.in);
  }

  public TaskManager(Scanner scanner) {
    this.scanner = scanner;
  }

  public void addTask() {
    try {
      System.out.println("Enter the task name:");
      String name = scanner.nextLine();
      System.out.println("Enter the task priority:");
      int priority = scanner.nextInt();
      scanner.nextLine();

      tasks.add(new Task(name, priority));
      System.out.println("Task added successfully.");
    } catch (Exception e) {
      System.out.println("Invalid input. Please try again.");
      scanner.nextLine();
    }
  }

  public void saveTasksToFile() {
    System.out.println("Enter the file path:");
    String filePath = scanner.nextLine();
    saveTasksToFile(filePath);
  }

  public void saveTasksToFile(String filePath) {
    try {
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
        out.writeObject(tasks);
      }
      System.out.println("Tasks saved successfully.");
    } catch (IOException e) {
      System.out.println("An error occurred while saving tasks to file.");
    }
  }

  public void loadTasksFromFile() {
    System.out.println("Enter the file path:");
    String filePath = scanner.nextLine();
    loadTasksFromFile(filePath);
  }

  public void loadTasksFromFile(String filePath) {
    try {
      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
        tasks = (List<Task>) in.readObject();
      }
      System.out.println("Tasks loaded successfully.");
      tasks.forEach(System.out::println);
    } catch (Exception e) {
      System.out.println("An error occurred while loading tasks from file.");
    }
  }

  public List<Task> getTasks() {
    return tasks;
  }
}
