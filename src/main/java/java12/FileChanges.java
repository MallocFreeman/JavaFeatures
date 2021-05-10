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

  /**
   * @return -1 if equal, else the position of mismatch
   * @throws IOException if something weird happens
   */
  private static long mismatch() throws IOException {
    Path demo1 = createTxtFileWithValue("demo1", "I am demo 1 :)");
    Path demo2 = createTxtFileWithValue("demo2", "I am demo 2 :)");
    return Files.mismatch(demo1, demo2);
  }

  private static Path createTxtFileWithValue(String fileName, String value) throws IOException {
    Path tempFile = Files.createTempFile(fileName, ".txt");
    Files.writeString(tempFile, value);
    return tempFile;
  }
}
