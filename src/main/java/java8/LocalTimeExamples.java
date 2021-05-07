package java8;

import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExamples {

  public static void main(String[] args) {}

  private static LocalTime now() {
    return LocalTime.now();
  }

  private static LocalTime specificTime() {
    return LocalTime.of(7, 40, 12, 1);
  }

  private static LocalTime specificTimeInOtherTimeZone() {
    return LocalTime.now(ZoneId.of("Asia/Kolkata"));
  }

  private static LocalTime secondOfDay() {
    return LocalTime.ofSecondOfDay(10000);
  }
}
