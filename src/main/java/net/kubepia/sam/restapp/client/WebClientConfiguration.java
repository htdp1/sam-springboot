package net.kubepia.sam.restapp.client;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfiguration {
  private static final String randomProfileUri = "https://randomuser.me/";
  private static final String tweetUri = "http://localhost:8080/tweet";

  @Bean(name = "webclient")
  public WebClient webclient() throws SSLException {
    SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
    HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext))
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

    // HttpClient httpClient =
    // HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
    WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
        .baseUrl(randomProfileUri).build();
    return webClient;
  }

  @Bean(name = "randomProfile")
  public WebClient getRandomProfileAPI() throws SSLException {
    SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
    HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext))
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

    // HttpClient httpClient =
    // HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
    WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
        .baseUrl(randomProfileUri).build();
    return webClient;
  }

  @Bean(name = "tweet")
  public WebClient getTweetAPI() throws SSLException {
    SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
    HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext))
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

    // HttpClient httpClient =
    // HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
    WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
        .baseUrl(tweetUri).build();
    return webClient;
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder)
      throws NoSuchAlgorithmException, KeyManagementException {

    TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }

      public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
      }

      public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
      }
    } };
    SSLContext sslContext = SSLContext.getInstance("SSL");
    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
    CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext)
        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
    HttpComponentsClientHttpRequestFactory customRequestFactory = new HttpComponentsClientHttpRequestFactory();
    customRequestFactory.setHttpClient(httpClient);
    return new RestTemplate(customRequestFactory);

  }
}
