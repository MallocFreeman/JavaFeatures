package java8.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Spliterator interface, introduced in Java 8, can be used for traversing and partitioning
 * sequences. It's a base utility for Streams, especially parallel ones.
 */
public class SpliteratorExamples {

  public static void main(String[] args) {
     trySplit();
    // tryAdvance();
//    estimatedSize();
  }

  private static void tryAdvance() {
    List<ToDo> dummies = createDummies(2);
    dummies.forEach(System.out::println);
    Spliterator<ToDo> spliterator = dummies.spliterator();
    spliterator.tryAdvance(
        elem -> elem.setDescription(elem.getDescription() + " has been edited by tryAdvance."));
    spliterator.forEachRemaining(SpliteratorExamples::process);
  }

  /**
   * The trySplit method tries to split it into two parts. Then the caller process elements, and
   * finally, the returned instance will process the others, allowing the two to be processed in
   * parallel.
   */
  private static void trySplit() {
    Spliterator<ToDo> spliterator = createDummies(4).spliterator();
    Spliterator<ToDo> otherSpliterator = spliterator.trySplit();

    spliterator.forEachRemaining(SpliteratorExamples::process);
    System.out.println("");
    otherSpliterator.forEachRemaining(SpliteratorExamples::process);
  }

  private static void estimatedSize() {
    System.out.println(createDummies(500000).spliterator().estimateSize());
  }

  private static List<ToDo> createDummies(int count) {
    return Stream.generate(() -> new ToDo("Always the same", false))
        .limit(count)
        .collect(Collectors.toList());
  }

  private static void process(ToDo toDo) {
    System.out.printf("%s processes %s%n", Thread.currentThread().getName(), toDo);
  }
}
