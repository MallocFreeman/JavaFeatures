package java8;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForEach {
  public static void main(String[] args) {
    List<Integer> dummyList = createDummyList();
    traverseWithIterator(dummyList);
    traverseWithEnhancedForEarch(dummyList);
    traverseWithIterableAndConsumer(dummyList);
  }

  private static List<Integer> createDummyList() {
    return IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
  }

  private static void traverseWithIterator(List<Integer> toTraverse) {
    Iterator<Integer> iterator = toTraverse.iterator();

    while (iterator.hasNext()) {
      process(iterator.next());
    }
  }

  private static void traverseWithEnhancedForEarch(List<Integer> toTraverse) {
    for (Integer integer : toTraverse) {
      process(integer);
    }
  }

  /*
   * Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic only.
   * forEach method takes java.util.function.Consumer object as argument, so it helps in having our business logic at a separate location
   * that we can reuse.
   */
  private static void traverseWithIterableAndConsumer(List<Integer> toTraverse) {
    toTraverse.forEach(ForEach::process);
  }

  private static void process(int element) {
    System.out.println(element);
  }
}
