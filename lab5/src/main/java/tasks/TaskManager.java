package tasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
  private List<Task> tasks = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

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
    try {
      System.out.println("Enter the file path:");
      String filePath = scanner.nextLine();
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
        out.writeObject(tasks);
      }
      System.out.println("Tasks saved successfully.");
    } catch (IOException e) {
      System.out.println("An error occurred while saving tasks to file.");
    }
  }

  public void loadTasksFromFile() {
    try {
      System.out.println("Enter the file path:");
      String filePath = scanner.nextLine();
      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
        tasks = (List<Task>) in.readObject();
      }
      System.out.println("Tasks loaded successfully.");
      tasks.forEach(System.out::println);
    } catch (Exception e) {
      System.out.println("An error occurred while loading tasks from file.");
    }
  }
}
