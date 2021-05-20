package java14;

/**
 * JDK 14 has introduced pattern matching for instanceof with the aim of eliminating boilerplate
 * code and make the developer's life a little bit easy.
 *
 * The pseudo code is extra written in this manner to see the difference.
 */
public class PatternMatchingPreview {

  public static void main(String[] args) {
    System.out.println(getStringFromPair(new Pair<>(42, "1337")));
  }

  private static String getStringFromPair(Pair<?, ?> pair) {
    StringBuilder stringBuilder = new StringBuilder();
    if (pair != null) {

      // Old way to check instance and cast
      if(pair.firstValue instanceof String){
        stringBuilder.append((String) pair.firstValue);
      }

    // Pattern matching to eliminate boilerplate code
      if(pair.secondValue instanceof String value){
        stringBuilder.append(value);
      }
    }
    return stringBuilder.toString();
  }

  private static class Pair<T, V>{
    private final T firstValue;
    private final V secondValue;

    public Pair(T firstValue, V secondValue) {
      this.firstValue = firstValue;
      this.secondValue = secondValue;
    }
  }
}
