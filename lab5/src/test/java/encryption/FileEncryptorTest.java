package encryption;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileEncryptorTest {

  private FileEncryptor fileEncryptor;

  @Before
  public void setUp() {
    fileEncryptor = new FileEncryptor();
  }

  @Test
  public void testEncrypt() throws IOException {
    String originalText = "Hello World!";
    char key = 'A';

    ByteArrayInputStream inputStream = new ByteArrayInputStream(originalText.getBytes(StandardCharsets.UTF_8));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    fileEncryptor.processStream(inputStream, outputStream, key, true); // Encrypt

    byte[] expectedEncrypted = new byte[originalText.length()];
    for (int i = 0; i < originalText.length(); i++) {
      expectedEncrypted[i] = (byte) (originalText.charAt(i) + key);
    }

    assertArrayEquals("Encrypted data should match expected result", expectedEncrypted, outputStream.toByteArray());
  }

  @Test
  public void testDecrypt() throws IOException {
    String originalText = "Hello World!";
    char key = 'A';

    byte[] encryptedText = new byte[originalText.length()];
    for (int i = 0; i < originalText.length(); i++) {
      encryptedText[i] = (byte) (originalText.charAt(i) + key);
    }

    ByteArrayInputStream inputStream = new ByteArrayInputStream(encryptedText);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    fileEncryptor.processStream(inputStream, outputStream, key, false); // Decrypt

    assertEquals("Decrypted data should match the original text", originalText,
        outputStream.toString(StandardCharsets.UTF_8.name()));
  }

  @Test(expected = IOException.class)
  public void testProcessStreamWithInvalidInput() throws IOException {
    InputStream failingInputStream = new InputStream() {
      @Override
      public int read() throws IOException {
        throw new IOException("Simulated I/O failure");
      }
    };

    OutputStream failingOutputStream = new OutputStream() {
      @Override
      public void write(int b) throws IOException {
        throw new IOException("Simulated I/O failure");
      }
    };

    fileEncryptor.processStream(failingInputStream, failingOutputStream, 'A', true);
  }
}
