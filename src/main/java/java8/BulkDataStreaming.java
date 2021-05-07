package java8;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BulkDataStreaming {
  public static void main(String[] args) {
    List<Integer> integers = IntStream.rangeClosed(0, 2 ^ 18).boxed().collect(Collectors.toList());

    System.out.printf(
        "Sequential stream processing took: %d ms.%n",
        executeProcessing(integers.stream().sequential()));

    System.out.printf(
        "Parallel stream processing took: %d ms.%n",
        executeProcessing(integers.stream().parallel()));
  }

  private static long executeProcessing(Stream<Integer> stream) {
    return measureTimeOfExecutionInMillis(() -> fakeWork(stream));
  }

  private static long measureTimeOfExecutionInMillis(Runnable runnable) {
    Instant start = Instant.now();
    runnable.run();
    return Duration.between(start, Instant.now()).toMillis();
  }

  private static void fakeWork(Stream<Integer> values) {
    values.forEach(
        value -> {
          try {
            TimeUnit.NANOSECONDS.sleep(25);
          } catch (InterruptedException e) {
            System.err.printf("Who interrupted me o.O chilling with my pal %d?%n", value);
          }
        });
  }
}
