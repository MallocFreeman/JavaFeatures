package java9;

// Before this we had to explicitly infer the type at instantiation
public class DiamondOperatorWithAnonymousClasses {
  public static void main(String[] args) {
    DataHolder<Integer> dataHolder = new DataHolder<>(1337) {
          // anonymous inner class
        };

    DataHolder<? extends Integer> betterOne = new DataHolder<>(42) {
          // anonymous inner class
        };

    DataHolder<?> ownHolder = new DataHolder<>(1) {
          // anonymous inner class
        };
  }

  public static class DataHolder<T> {
    T data;

    public DataHolder(T data) {
      this.data = data;
    }

    public T getData() {
      return data;
    }
  }
}
