import cat.ProcessCatsList;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
  public static String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";


  public static void main(String[] args) {
    getRequest();
  }

  public static void getRequest() {
    ProcessCatsList processCatsList = new ProcessCatsList();

    CloseableHttpClient httpClient = HttpClientBuilder.create()
      .setUserAgent("CatList")
      .setDefaultRequestConfig(RequestConfig.custom()
        .setConnectTimeout(5000)
        .setSocketTimeout(30000)
        .setRedirectsEnabled(false)
        .build())
      .build();


    HttpGet request = new HttpGet(URL);
    request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

    CloseableHttpResponse response;

    try {
      response = httpClient.execute(request);
      String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);

      processCatsList.showFilteredCatsList(processCatsList.jsonResponseToList(body));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
