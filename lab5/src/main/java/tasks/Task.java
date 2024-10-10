package tasks;

import java.io.Serializable;

public class Task implements Serializable {
  private String name;
  private int priority;

  public Task(String name, int priority) {
    this.name = name;
    this.priority = priority;
  }

  @Override
  public String toString() {
    return "Task{name='" + name + "', priority=" + priority + "}";
  }
}
