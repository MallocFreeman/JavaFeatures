package java9;

import java.util.Set;

public class ImmutableSet {
  public static void main(String[] args) {
    Set<String> someImmutableSet = Set.of("Das", "hier", "ist", "immutable");
    someImmutableSet.add(
        "WHAT ?!"); // THROWS Exception in thread "main" java.lang.UnsupportedOperationException
  }
}
