package java13;

/**
 * <a href="https://openjdk.java.net/jeps/354">Switch expression enhancement proposal</a>
 */
public class SwitchExpressions {
  public static void main(String[] args) {
    System.out.println(magicMathMethodInOldAndFaulty(MagicMathInstruction.DOUBLE_ME, 42));
    System.out.println(magicMathMethodInOld(MagicMathInstruction.DOUBLE_ME, 42));
    System.out.println(magicMathMethod(MagicMathInstruction.DOUBLE_ME, 42));

    System.out.println(magicMathMethodInOldAndFaulty(MagicMathInstruction.SQUARE_ME, 42));
    System.out.println(magicMathMethodInOld(MagicMathInstruction.SQUARE_ME, 42));
    System.out.println(magicMathMethod(MagicMathInstruction.SQUARE_ME, 42));
  }

  private static int magicMathMethodInOld(MagicMathInstruction instruction, int input){
    var result = input;
    switch (instruction){
      case DOUBLE_ME:result*=2; break;
      case SQUARE_ME:result*=result; break;
    }
    return result;
  }

  private static int magicMathMethodInOldAndFaulty(MagicMathInstruction instruction, int input){
    var result = input;
    switch (instruction){
      case DOUBLE_ME:result*=2;
      case SQUARE_ME:result*=result;
    }
    return result;
  }

  private static int magicMathMethod(MagicMathInstruction instruction, int input){
    return switch (instruction){
      case DOUBLE_ME -> input * 2;
      case SQUARE_ME -> input * input;
    };
  }

  private enum MagicMathInstruction{
    DOUBLE_ME, SQUARE_ME;
  }
}
