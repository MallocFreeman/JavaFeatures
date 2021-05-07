package java9;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Empty optionals had the problem in Java 8 that you had to filter empty optionals in dumbest ways
 * to clear a stream from that elements. Now there is an Optional stream doing the same under the
 * hood simplifying
 */
public class OptionalStreamingImprovement {

  public static void main(String[] args) {
    System.out.println(oldWay().equals(newWay()));
  }

  private static List<Integer> oldWay() {
    return streamWithEmptyValues()
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());
  }

  private static List<Integer> newWay() {
    return streamWithEmptyValues().flatMap(Optional::stream).collect(Collectors.toList());
  }

  private static Stream<Optional<Integer>> streamWithEmptyValues() {
    return IntStream.rangeClosed(0, 100)
        .boxed()
        .map(number -> isEven(number) ? Optional.empty() : Optional.of(number));
  }

  private static boolean isEven(int number) {
    return number % 2 == 0;
  }
}
