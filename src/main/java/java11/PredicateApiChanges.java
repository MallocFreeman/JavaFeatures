package java11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
A static not method has been added to the Predicate interface. We can use it to negate an existing predicate, much like the negate method:
 */
public class PredicateApiChanges {

  public static void main(String[] args) {
    List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
    sampleList.stream().filter(Predicate.not(String::isBlank)).collect(Collectors.toList());
  }
}
