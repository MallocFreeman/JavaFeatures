package java8;

/*
Instant class is used to work with machine readable time format, it stores date time in unix timestamp. Let’s see it’s usage with a simple program.
 */
public class Instant {
  public static void main(String[] args) {
    System.out.println(currentTimeStampInUnix());
    System.out.println(toEpochMillis(currentTimeStampInUnix()));
    System.out.println(duration(12).getSeconds());
  }

  private static java.time.Instant currentTimeStampInUnix() {
    return java.time.Instant.now();
  }

  private static java.time.Instant toEpochMillis(java.time.Instant timestamp) {
    return java.time.Instant.ofEpochMilli(timestamp.toEpochMilli());
  }

  private static java.time.Duration duration(int days) {
    return java.time.Duration.ofDays(days);
  }
}
