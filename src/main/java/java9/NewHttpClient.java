package java9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class NewHttpClient {

  public static void main(String[] args)
      throws IOException, InterruptedException, URISyntaxException {
    System.out.println(handleRequest(createRequest()));
  }

  private static String handleRequest(HttpRequest httpRequest)
      throws IOException, InterruptedException, URISyntaxException {
    return HttpClient.newHttpClient().send(createRequest(), BodyHandlers.ofString()).body();
  }

  private static HttpRequest createRequest() throws URISyntaxException {
    return HttpRequest.newBuilder().uri(createURI()).GET().build();
  }

  private static URI createURI() throws URISyntaxException {
    return new URI("https://postman-echo.com/get");
  }
}
