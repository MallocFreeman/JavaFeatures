package java12;

import java.util.List;
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
   * Teeing = Abschlag Namings seems weird...
   *
   * @param args
   */
  public static void main(String[] args) {
    List<Integer> randomIntegerStream = createRandomIntegerStream();

    System.out.println(meanOld(randomIntegerStream));
    System.out.println(meanNew(randomIntegerStream));
  }

  /**
   * This example is not really good. Min/Max in one iteration would suit better ! For the next
   * iteration.
   */
  private static double meanNew(List<Integer> randomValues) {
    return randomValues.stream()
        .collect(
            Collectors.teeing(
                Collectors.summingDouble(i -> i),
                Collectors.counting(),
                (sum, count) -> sum / count));
  }

  private static double meanOld(List<Integer> randomValues) {
    double count = 0;
    double sum = 0;
    for (Integer integer : randomValues) {
      count++;
      sum += integer;
    }
    return sum / count;
  }

  private static double meanOld2(List<Integer> randomValues) {
    return randomValues.stream().mapToInt(Integer::intValue).sum() / (randomValues.size() * 1.0);
  }

  private static List<Integer> createRandomIntegerStream() {
    return IntStream.rangeClosed(0, (int) (Math.random() * 1000))
        .boxed()
        .collect(Collectors.toList());
  }
}
