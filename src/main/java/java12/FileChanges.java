package java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The method is used to compare two files and find the position of the first mismatched byte in
 * their contents.
 *
 * <p>The return value will be in the inclusive range of 0L up to the byte size of the smaller file
 * or -1L if the files are identical.
 */
public class FileChanges {

  public static void main(String[] args) throws IOException {
    System.out.println(mismatch());
  }

  private static long mismatch() throws IOException {
    Path filePath1 = Files.createTempFile("demo1", ".txt");
    Path filePath2 = Files.createTempFile("demo2", ".txt");
    Files.writeString(filePath1, "I am demo 1 :)");
    Files.writeString(filePath2, "I am demo 2 :)");
    return Files.mismatch(filePath1, filePath2);
  }
}
