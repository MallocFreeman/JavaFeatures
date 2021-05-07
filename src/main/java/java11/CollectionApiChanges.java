package java11;

import java.util.Arrays;
import java.util.List;

// The java.util.Collection interface contains a new default toArray method which takes an
// IntFunction argument.
public class CollectionApiChanges {
  public static void main(String[] args) {
    List<String> list = createDummies();
    createArray(list);
    createArrayOnOldWay(list);
  }

  private static String[] createArrayOnOldWay(List<String> listToConvert) {
    return listToConvert.toArray(new String[0]);
  }

  private static String[] createArray(List<String> listToConvert) {
    return listToConvert.toArray(String[]::new);
  }

  private static List<String> createDummies() {
    return Arrays.asList("I", "am", "testing", "Java", "features");
  }
}
