package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tasks.TaskManager;
import tasks.Task;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TaskManagerTest {

  private TaskManager taskManager;
  private ByteArrayOutputStream consoleOutput;
  private PrintStream originalOut;

  @Before
  public void setUp() {
    String simulatedUserInput = "Test Task\n3\n";
    Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    taskManager = new TaskManager(scanner);

    consoleOutput = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(consoleOutput));
  }

  @After
  public void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  public void testAddTask() {
    taskManager.addTask();

    List<Task> tasks = taskManager.getTasks();
    assertEquals(1, tasks.size());
    assertEquals("Test Task", tasks.get(0).getName());
    assertEquals(3, tasks.get(0).getPriority());

    String output = consoleOutput.toString();
    assertTrue(output.contains("Task added successfully."));
  }

  @Test
  public void testSaveAndLoadTasksToFile() throws IOException, ClassNotFoundException {
    taskManager.addTask();

    File tempFile = File.createTempFile("tasks", ".dat");
    taskManager.saveTasksToFile(tempFile.getAbsolutePath());

    taskManager.getTasks().clear();
    taskManager.loadTasksFromFile(tempFile.getAbsolutePath());

    List<Task> tasks = taskManager.getTasks();
    assertEquals(1, tasks.size());
    assertEquals("Test Task", tasks.get(0).getName());
    assertEquals(3, tasks.get(0).getPriority());

    tempFile.deleteOnExit();
  }

  @Test
  public void testLoadTasksFromFileWithInvalidPath() {
    taskManager.loadTasksFromFile("invalid/path");

    String output = consoleOutput.toString();
    assertTrue(output.contains("An error occurred while loading tasks from file."));
  }

  @Test
  public void testSaveTasksToFileWithInvalidPath() {
    taskManager.saveTasksToFile("/invalid/path");

    String output = consoleOutput.toString();
    assertTrue(output.contains("An error occurred while saving tasks to file."));
  }
}
