package java9;

public class Autoclosables {
  public static void main(String[] args) {
    java7();

    MyFreshAutoclosable freshAutoclosable = new MyFreshAutoclosable();
    java9(freshAutoclosable);
  }

  /**
   * In Java 7, the try-with-resources syntax requires a fresh variable to be declared for each
   * resource being managed by the statement.
   *
   * <p>In Java 9 there is an additional refinement: if the resource is referenced by a final or
   * effectively final variable, a try-with-resources statement can manage a resource without a new
   * variable being declared:
   *
   * @param freshAutoclosable the final reference to an AutoClosable
   */
  private static void java9(final MyFreshAutoclosable freshAutoclosable) {
    try (freshAutoclosable) {
      System.out.println("Pretending to open a resource :D");
    } catch (Exception e) {
      System.out.println(
          "Ooopsi, File not found or whatever, just think that I am a real resource ;)");
    }
  }

  private static void java7() {
    try (MyFreshAutoclosable freshAutoclosable = new MyFreshAutoclosable()) {
      System.out.println("Pretending to open a resource :D");
    } catch (Exception e) {
      System.out.println(
          "Ooopsi, File not found or whatever, just think that I am a real resource ;)");
    }
  }

  private static class MyFreshAutoclosable implements AutoCloseable {
    public MyFreshAutoclosable() {
      System.out.println("Constructor call");
    }

    @Override
    public void close() throws Exception {
      System.out.println("Close called after stepping out of the resource block.");
    }
  }
}
