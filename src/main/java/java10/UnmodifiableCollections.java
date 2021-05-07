package java10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnmodifiableCollections {
  public static void main(String[] args) {
    unmodifiableListExample();
    collectorsCanCollectToUnmodifaibleList();
  }

  // Modifying such a collection results in UnsupportedOperationExceptionruntime exception
  public static void unmodifiableListExample() {
    List<Integer> unmodifiable = List.copyOf(createDummyList());
    unmodifiable.add(42);
  }

  public static void collectorsCanCollectToUnmodifaibleList() {
    List<Integer> unmodifiable =
        createDummyList().stream()
            .filter(UnmodifiableCollections::isEven)
            .collect(Collectors.toUnmodifiableList());

    unmodifiable.add(11);
  }

  private static List<Integer> createDummyList() {
    return IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
  }

  private static boolean isEven(int number) {
    return number % 2 == 0;
  }
}
