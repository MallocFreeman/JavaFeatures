package java8;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * Immutability: All the classes in the new Date Time API are immutable and good for multithreaded
 * environments.
 *
 * <p>Separation of Concerns: The new API separates clearly between human readable date time and
 * machine time (unix timestamp). It defines separate classes for Date, Time, DateTime, Timestamp,
 * Timezone etc.
 *
 * <p>Clarity: The methods are clearly defined and perform the same action in all the classes. For
 * example, to get the current instance we have now() method. There are format() and parse() methods
 * defined in all these classes rather than having a separate class for them.
 *
 * <p>Utility operations: All the new Date Time API classes comes with methods to perform common
 * tasks, such as plus, minus, format, parsing, getting separate part in date/time etc.
 *
 * <p>Extendable: The new Date Time API works on ISO-8601 calendar system but we can use it with
 * other non ISO calendars as well.
 *
 * <p>java.time This is the base package of new Java Date Time API. All the major base classes are
 * part of this package, such as LocalDate, LocalTime, LocalDateTime, Instant, Period, Duration etc.
 * All of these classes are immutable and thread safe. Most of the times, these classes will be
 * sufficient for handling common requirements.
 *
 * <p>java.time.chrono This package defines generic APIs for non ISO calendar systems. We can extend
 * AbstractChronology class to create our own calendar system.
 *
 * <p>java.time.format This package contains classes used for formatting and parsing date time
 * objects. Most of the times, we would not be directly using them because principle classes in
 * java.time package provide formatting and parsing methods.
 *
 * <p>java.time.temporal This package contains temporal objects and we can use it for find out
 * specific date or time related to date/time object. For example, we can use these to find out the
 * first or last day of the month. You can identify these methods easily because they always have
 * format “withXXX”.
 *
 * <p>java.time.zone This package contains classes for supporting different time zones and their
 * rules.
 */
public class LocalDateExamples {
  public static void main(String[] args) {
    System.out.println(createToday());
    System.out.println(createSpecificDate(1993, Month.APRIL, 20));
    System.out.println(createTodayForOtherTimeZone());
    System.out.println(nThDateOfYear(2021, 110));
  }

  private static LocalDate createToday() {
    return LocalDate.now();
  }

  private static LocalDate createTodayForOtherTimeZone() {
    return LocalDate.now(ZoneId.of("Asia/Kolkata"));
  }

  private static LocalDate createSpecificDate(int year, Month month, int day) {
    return LocalDate.of(year, month, day);
  }

  // Getting date from the base date i.e 01/01/1970
  private static LocalDate epochDay() {
    return LocalDate.ofEpochDay(365);
  }

  private static LocalDate nThDateOfYear(int year, int dayOfYear) {
    return LocalDate.ofYearDay(year, dayOfYear);
  }
}
