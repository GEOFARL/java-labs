package encryption;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileEncryptor {
  private Scanner scanner = new Scanner(System.in);

  public void encryptDecryptFile() {
    try {
      System.out.println("Enter operation (encrypt/decrypt):");
      String operation = scanner.nextLine();
      System.out.println("Enter source file path:");
      String sourceFilePath = scanner.nextLine();
      System.out.println("Enter destination file path:");
      String destinationFilePath = scanner.nextLine();
      System.out.println("Enter key (char):");
      char key = scanner.nextLine().charAt(0);

      if (operation.equals("encrypt")) {
        try (FileInputStream fin = new FileInputStream(sourceFilePath);
            FileOutputStream fout = new FileOutputStream(destinationFilePath)) {
          processStream(fin, fout, key, true);
        }
        System.out.println("File encrypted successfully.");
      } else if (operation.equalsIgnoreCase("decrypt")) {
        try (FileInputStream fin = new FileInputStream(sourceFilePath);
            FileOutputStream fout = new FileOutputStream(destinationFilePath)) {
          processStream(fin, fout, key, false);
        }
        System.out.println("File decrypted!");
      } else {
        System.out.println("Invalid operation.");
      }
    } catch (Exception e) {
      System.out.println("An error occurred while encrypting/decrypting file.");
    }
  }

  private void processStream(InputStream in, OutputStream out, char key, boolean encrypt) throws IOException {
    try (BufferedInputStream bin = new BufferedInputStream(in);
        BufferedOutputStream bout = new BufferedOutputStream(out)) {
      int data;
      while ((data = bin.read()) != -1) {
        if (encrypt) {
          bout.write(data + key); // Encryption
        } else {
          bout.write(data - key); // Decryption
        }
      }
    }
  }
}
