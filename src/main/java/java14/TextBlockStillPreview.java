package java14;

/**
 * Text blocks continue their journey to getting a mainstream upgrade and are still available as preview features.
 *
 * In addition to the capabilities from JDK 13 to make multiline strings easier to use, in their second preview, text blocks now have two new escape sequences:
 *
 *     \: to indicate the end of the line, so that a new line character is not introduced
 *     \s: to indicate a single space
 */
public class TextBlockStillPreview {
  String multiline = "A quick brown fox jumps over a lazy dog; the lazy dog howls loudly.";

  String multilineAsTextblock = """
    A quick brown fox jumps over a lazy dog; \
    the lazy dog howls loudly.""";
}
