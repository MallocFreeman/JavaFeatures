package java8.spliterator;

public class ToDo {
  private static int id;
  private final int uuid;
  private String description;
  private final boolean done;

  public ToDo(String description, boolean done) {
    uuid = id++;
    this.description = description;
    this.done = done;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public boolean isDone() {
    return done;
  }

  public int getUuid() {
    return uuid;
  }

  @Override
  public String toString() {
    return "ToDo{"
        + "uuid="
        + uuid
        + ", description='"
        + description
        + '\''
        + ", done="
        + done
        + '}';
  }
}
