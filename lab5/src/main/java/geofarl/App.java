package geofarl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import encryption.FileEncryptor;
import frequency_count.TagFrequencyCounter;
import tasks.TaskManager;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private TaskManager taskManager = new TaskManager();
    private FileEncryptor fileEncryptor = new FileEncryptor();
    private TagFrequencyCounter tagCounter = new TagFrequencyCounter();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Find line with maximum words");
            System.out.println("2. Add task");
            System.out.println("3. Save tasks to file");
            System.out.println("4. Load tasks from file");
            System.out.println("5. Encrypt/Decrypt file");
            System.out.println("6. Count HTML tags frequency");
            System.out.println("7. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Present working directory: " + System.getProperty("user.dir"));
                        findLineWithMaxWordsFromFilePath();
                        break;
                    case 2:
                        taskManager.addTask();
                        break;
                    case 3:
                        taskManager.saveTasksToFile();
                        break;
                    case 4:
                        taskManager.loadTasksFromFile();
                        break;
                    case 5:
                        fileEncryptor.encryptDecryptFile();
                        break;
                    case 6:
                        tagCounter.run();
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public String findLineWithMaxWords(BufferedReader reader) {
        String maxLine = "";
        int maxWords = 0;

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                int wordCount = line.split("\\s+").length;
                if (wordCount > maxWords) {
                    maxWords = wordCount;
                    maxLine = line;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return maxLine;
    }

    public void findLineWithMaxWordsFromFilePath() {
        try {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filePath)));
            String maxLine = findLineWithMaxWords(reader);
            System.out.println("Line with maximum words: " + maxLine);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
