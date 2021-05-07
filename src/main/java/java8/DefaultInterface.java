package java8;

import java.io.PrintStream;

// https://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method

/**
 * Default methods were introduced to provide backward compatibility for old interfaces so that they
 * can have new methods without affecting existing code.
 */
public class DefaultInterface {

  public static void main(String... args) {}

  private static class LordOfThePrinter implements ErrorPrinter, ConsolePrinter {
    /*
     * When implementing interfaces with default methods that have the same signature you have to provide
     * an implementation cause it is not clear which default implementation shall be used.
     *
     * We know that Java does not allow us to extend multiple classes because it will result in the
     * “Diamond Problem” where the compiler can’t decide which superclass method to use.
     * With the default methods, the diamond problem would arise for interfaces too
     *
     * So to make sure, this problem won’t occur in interfaces, it’s made mandatory to provide an
     * implementation for common default methods of interfaces. So if a class is implementing both
     * the interfaces, it will have to provide an implementation for the process() method
     * otherwise the compiler will throw a compile time error.
     */
    @Override
    public void print(String toBePrinted) {
      ErrorPrinter.super.print(toBePrinted);
      ConsolePrinter.super.print(toBePrinted);
    }
  }

  public interface ErrorPrinter extends Printer {
    default void print(String toBePrinted) {
      Printer.super.print(System.err, "Printed " + toBePrinted + " in red, cause it's rad");
    }
  }

  private interface ConsolePrinter extends Printer {
    default void print(String toBePrinted) {
      Printer.super.print(System.out, "Printed " + toBePrinted + " in blue, cause it's cool");
    }
  }

  private interface Printer {
    default void print(PrintStream printStream, String value) {
      printStream.println(value);
    }

    static void justForCompletion() {
      System.out.println(
          "I am a static implementation just like in any other class. But that's new too ;)");
    }
  }
}
