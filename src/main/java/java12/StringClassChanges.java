package java12;

public class StringClassChanges {

  public static void main(String[] args) {
    indent(10);
    indent(-10);
  }

  private static void indent(int indentCount) {
    String text = "     Check out my fresh String. Work with me suger!";
    text = text.indent(indentCount);
    System.out.println(text);
  }

  private static void transform() {
    String text = "Thomas";
    String transformed = text.transform(value -> new StringBuilder(value).reverse().toString());

    System.out.println(transformed);
  }
}
