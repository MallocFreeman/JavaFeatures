package java10;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

// Styleguide for VAR-Reference : https://openjdk.java.net/projects/amber/LVTIstyle.html
public class LocalVariableTypeInference {
  public static void main(String[] args) {
    goodbyeJava9();
    helloJava10();
    var listSetMap = tryAHarderOne();
    stopThatsIllegal();

    // Generic class using var does not help in understanding...
    whenNotToUse(new MysteryBox<>(listSetMap));
  }

  public static void goodbyeJava9() {
    String message = "Good bye, Java 9";

    if (message instanceof String) {
      System.out.println(message);
    }
  }

  /*
  We don't provide the data type of message. Instead, we mark the message as a var, and the compiler
  infers the type of message from the type of the initializer present on the right-hand side.
  */
  public static void helloJava10() {
    var message = "Hello Java 10";

    if (message instanceof String) {
      System.out.println(message);
    }
  }

  /*
   This also helps to focus on the variable name rather than on the variable type.
   Another thing to note is that var is not a keyword – this ensures backward compatibility for
   programs using var say, as a function or variable name. var is a reserved type name, just like int.
   Finally, note that there is no runtime overhead in using var nor does it make Java a
   dynamically typed language.
   The type of the variable is still inferred at compile time and cannot be changed later.
  */
  public static Map<List<char[]>, Set<Comparable<Serializable>>> tryAHarderOne() {
    Map<List<char[]>, Set<Comparable<Serializable>>> oldSchool = new HashMap<>();
    var var = new HashMap<List<char[]>, Set<Comparable<Serializable>>>();
    return var;
  }

  public static void stopThatsIllegal() {
    //        var n; // error: cannot use 'var' on variable without initializer

    //        var emptyList = null; // error: variable initializer is 'null'

    //        var p = (String s) -> s.length() > 10; // error: lambda expression needs an explicit
    // target-type

    //        var arr = {1, 2, 3}; // error: array initializer needs an explicit target-type
  }

  /*
   There are situations where var can be used legally, but may not be a good idea to do so.
   For example, in situations where the code could become less readable:
   Here, although a legal use of var, it becomes difficult to understand the type returned by
   the process()making the code less readable.
  */
  public static void whenNotToUse(MysteryBox mysteryBox) {
    var result = mysteryBox.process();
  }

  public static class MysteryBox<T> {
    private final T object;

    public MysteryBox(T object) {
      this.object = object;
    }

    T process() {
      System.out.println("Nobody knows what I am doing ! Muhahhahaha :D");
      return null;
    }
  }
}
