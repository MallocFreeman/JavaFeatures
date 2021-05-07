package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileApiChanges {
  public static void main(String[] args) throws IOException {
    Path path = writeStringToFile(createTempFile(), createText());
    System.out.println(Files.readString(path));
  }

  private static String createText() {
    return "What is going on.\n".repeat(1337);
  }

  private static Path createTempFile() throws IOException {
    return Files.createTempFile("test", ".txt");
  }

  private static Path writeStringToFile(Path file, String text) throws IOException {
    return Files.writeString(file, text);
  }
}
