package java12;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * It is a composite of two downstream collectors. Every element is processed by both downstream
 * collectors. Then their results are passed to the merge function and transformed into the final
 * result.
 *
 * <p>The example usage of teeing collector is counting an average from a set of numbers. The first
 * collector parameter will sum up the values, and the second one will give us the count of all
 * numbers. The merge function will take these results and count the average:
 */
public class CollectorsChanges {

  /**
   * https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/stream/Collectors.html
   * Teeing = Abschlag
   * Namings seems weird...
   *
   * @param args
   */
  public static void main(String[] args) {
    double mean =
        IntStream.rangeClosed(1, 100)
            .boxed()
            .collect(
                Collectors.teeing(
                    Collectors.summingDouble(i -> i),
                    Collectors.counting(),
                    (sum, count) -> sum / count));
    System.out.println(mean);
  }
}
