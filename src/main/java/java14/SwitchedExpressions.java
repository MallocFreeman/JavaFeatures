package java14;

/**
 * These were first introduced as a preview feature in JDK 12, and even in Java 13, they continued
 * as preview features only. But now, switch expressions have been standardized so that they are
 * part and parcel of the development kit.
 *
 * <p>What this effectively means is that this feature can now be used in production code, and not
 * just in the preview mode to be experimented with by developers.
 */
public class SwitchedExpressions {
  public static void main(String[] args) {
    String monday = "MONDAY";
    System.out.println(old(monday) == notOld(monday));
  }

  private static boolean old(String day) {
    boolean isTodayHoliday;
    switch (day) {
      case "MONDAY":
      case "TUESDAY":
      case "WEDNESDAY":
      case "THURSDAY":
      case "FRIDAY":
        isTodayHoliday = false;
        break;
      case "SATURDAY":
      case "SUNDAY":
        isTodayHoliday = true;
        break;
      default:
        throw new IllegalArgumentException("What's a " + day);
    }
    return isTodayHoliday;
  }

  private static boolean notOld(String day) {
    return switch (day) {
      case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
      case "SATURDAY", "SUNDAY" -> true;
      default -> throw new IllegalArgumentException("What's a " + day);
    };
  }
}
