package java9;

import java.util.Optional;

public class ProcessInformation {
  public static void main(String[] args) {
    print(getCurrentInfo().user());
    print(getCurrentInfo().commandLine());
    print(getCurrentInfo().totalCpuDuration());
    print(getCurrentInfo().arguments());
    print(getCurrentInfo().startInstant());
    print(getCurrentInfo().command());

    killAllChildProcesses();
  }

  private static ProcessHandle.Info getCurrentInfo() {
    return ProcessHandle.current().info();
  }

  private static void print(Optional<?> obj) {
    System.out.println(obj.isPresent() ? obj.get() : "-- leer");
  }

  private static void killAllChildProcesses() {
    ProcessHandle.current().children().forEach(ProcessInformation::kill);
  }

  private static void kill(ProcessHandle processHandle) {
    if (processHandle.destroy()) {
      System.err.printf("Could not kill process %s", processHandle.info());
    }
  }
}
