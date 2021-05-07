package java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileImprovements {

  public static void main(String[] args) throws IOException, URISyntaxException {
//    listAllFilesInOneLine();
    readLinesOfFileInOneLine();
    readLinesOfFileInOneLineWithBufferedReader();
  }

  private static void readLinesOfFileInOneLine() throws IOException, URISyntaxException {
    Files.lines(findDummy()).forEach(System.out::println);
  }

  private static void readLinesOfFileInOneLineWithBufferedReader()
      throws FileNotFoundException, URISyntaxException {
    new BufferedReader(new FileReader(findDummy().toFile())).lines().forEach(System.out::println);
  }

  private static void listAllFilesInOneLine() throws IOException, URISyntaxException {
    Files.lines(findDummy().getParent()).forEach(System.out::println);
  }

  private static Path findDummy() throws URISyntaxException {
    return Paths.get(FileImprovements.class.getResource("/Dummy.txt").toURI());
  }
}
