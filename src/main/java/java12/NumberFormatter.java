package java12;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

/**
 * Java 12 comes with a new number formatter – the CompactNumberFormat. It's designed to represent a
 * number in a shorter form, based on the patterns provided by a given locale.
 */
public class NumberFormatter {

  /**
   * As mentioned before, the locale parameter is responsible for providing proper format patterns.
   * The format style can be either SHORT or LONG. For a better understanding of the format styles,
   * let's consider number 1000 in the US locale. The SHORT style would format it as “10K”, and the
   * LONG one would do it as “10 thousand”.
   *
   * @param args not used for the demo
   */
  public static void main(String[] args) {
    System.out.println(formatLong(2592));
    System.out.println(formatShort(2592));
  }

  private static String formatLong(long number) {
    return format(Style.LONG, number);
  }

  private static String formatShort(long number) {
    return format(Style.SHORT, number);
  }

  private static String format(NumberFormat.Style style, long number) {
    NumberFormat likesLong = NumberFormat.getCompactNumberInstance(new Locale("de", "DE"), style);
    likesLong.setMaximumFractionDigits(2);
    return likesLong.format(number);
  }
}
