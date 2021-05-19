package java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionAPIImprovements {
  public static void main(String[] args) {
    forEachRemaining(createDummies());
    removeIf();
  }

  private static void forEachRemaining(List<Integer> values) {
    values.iterator().forEachRemaining(System.out::println);
  }

  private static void removeIf() {
    createDummies().removeIf(value -> value % 2 == 0);
  }

  private static List<Integer> createDummies() {
    return IntStream.rangeClosed(0, Integer.MAX_VALUE).boxed().collect(Collectors.toList());
  }
}
