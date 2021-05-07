package java11;

import java.util.function.Predicate;

/*
Java 11 adds a few new methods to the String class: isBlank, lines, strip,
 stripLeading, stripTrailing, and repeat.
*/
public class StringApiChanges {

  public static void main(String[] args) {
    isBlank_Lines_Strip();
    repeat();
  }

  private static void repeat() {
    String repeatMe = ":)";
    String repeat = repeatMe.repeat(42);
    System.out.println(repeat);
    System.out.println(repeat.replace(')', '('));
  }

  private static void isBlank_Lines_Strip() {
    String multiLine = "This string can be replaced by \n multiline strings from \n Java 16";
    multiLine
        .lines()
        .filter(Predicate.not(String::isBlank))
        .map(String::strip)
        .forEach(System.out::println);
  }
}
