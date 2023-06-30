package kr.co.mz.singlethread.utils.http;

import java.net.MalformedURLException;
import java.net.URL;

public class ParsedRequest {

  private final String method;
  private final URL url;
  private final String version;
  private boolean cacheDtoRequest = false;

  private final String uriExtension;


  public ParsedRequest(String requestLine) throws MalformedURLException, ArrayIndexOutOfBoundsException {
    var splitRequestLine = requestLine.split(" ");
    method = splitRequestLine[0];
    url = new URL("http://" + splitRequestLine[1]);
    version = splitRequestLine[2];

    if (url.getPath().startsWith("/cache")) {// 요청마다 다를 수도 있어서?
      cacheDtoRequest = true;
    }

    String[] uriParts = url.getFile().split("\\.");
    uriExtension = uriParts[1];

  }


  public String getMethod() {
    return method;
  }

  public URL getUrl() {
    return url;
  }

  public String getVersion() {
    return version;
  }

  public String getProtocol() {
    return url.getProtocol();
  }

  public String getPath() {
    return url.getPath();
  }

  public int getPort() {
    return url.getPort();
  }

  public String getQuery() {
    return url.getQuery();
  }

  public String getUriExtension() {
    return uriExtension;
  }

  public boolean isCacheDtoRequest() {
    return cacheDtoRequest;
  }

}

