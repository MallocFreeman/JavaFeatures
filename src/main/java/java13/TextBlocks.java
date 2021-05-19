package java13;

/**
 * <a href="https://openjdk.java.net/jeps/368">Text block enhancement proposal</a>
 * <a href="https://www.baeldung.com/java-text-blocks">More on text blocks</a>
 */
public class TextBlocks {
  public static void main(String[] args) {
    System.out.println(json("vantablack", 500));
    System.out.println(jsonAsBlock("vantablack", 500));
  }

  private static String json(String color, int weight){
    return String.format("{\n\t\"color\": \"%s\"\n\t\"weight\": %d\n}", color, weight);
  }


  private static String jsonAsBlock(String color, int weight){
    return """
        {
          "color": "%s"
          "weight": %d
        }
        """.formatted(color, weight);
  }
}
