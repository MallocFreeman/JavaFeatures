package java14;

import java.util.Objects;

/** @see <a href="https://www.baeldung.com/java-record-keyword">Record at Baeldung</a> */
public class RecordPreview {

  public static void main(String[] args) {
    OldDataClass thomas = new OldDataClass("Thomas", 28);
    NewDataClass freshThomas = new NewDataClass("Thomas", 28);
  }

  private static class OldDataClass {
    private final String name;
    private final long age;

    public OldDataClass(String name, long age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public long getAge() {
      return age;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      OldDataClass that = (OldDataClass) o;
      return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age);
    }

    @Override
    public String toString() {
      return "OldDataClass{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
  }

  /**
   * As of JDK 14, we can replace our repetitious data classes with records. Records are immutable
   * data classes that require only the type and name of fields.
   *
   * <p>The equals, hashCode, and toString methods, as well as the private, final fields, and public
   * constructor, are generated by the Java compiler.
   */
  private static record NewDataClass(String name, long age) {
    public static long EMPTY_VALUE = -1;
    // We can still use a constructor to check for specifics.
    // Additionally, declaring a no-argument constructor and one with an argument list
    // matching the generated constructor results in a compilation error.
    public NewDataClass {
      Objects.requireNonNull(name);
    }

    public NewDataClass(String name) {
      this(name, EMPTY_VALUE);
    }
  }
}