package java10;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
   java.util.Optional, java.util.OptionalDouble, java.util.OptionalIntand java.util.OptionalLong
   each got a new method orElseThrow() which doesn't take any argument and throws
   NoSuchElementException if no value is present:
*/
public class OrElseThrowWithoutParameter {

  public static void main(String[] args) {
    createOnlyOdds().stream().filter(OrElseThrowWithoutParameter::isEven).findAny().orElseThrow();
  }

  public static List<Integer> createOnlyOdds() {
    return createDummies().filter(OrElseThrowWithoutParameter::isOdd).toList();
  }

  private static Stream<Integer> createDummies() {
    return IntStream.rangeClosed(0, 100).boxed();
  }

  private static boolean isOdd(int i) {
    return !isEven(i);
  }

  private static boolean isEven(int i) {
    return i % 2 == 0;
  }
}
