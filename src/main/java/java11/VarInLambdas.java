package java11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//We can make use of this feature to apply modifiers to our local variables, like defining a type annotation
public class VarInLambdas {
  public static void main(String[] args) {
    List<String> sampleList = createDummies();
    example(sampleList);
  }

  private static void example(List<String> values){
//    values.stream().map((@NonNull var) x -> x.toUpperCase()).collect(Collectors.joining(", "));;
  }

  private static List<String> createDummies(){
    return Arrays.asList("Var", "in", "lambdas");
  }
}
