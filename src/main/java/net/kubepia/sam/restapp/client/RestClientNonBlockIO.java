package net.kubepia.sam.restapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
@RequestMapping("client")
public class RestClientNonBlockIO {
  // String uri = "https://randomuser.me/api/";
  String uri = "http://localhost:8080/rest/tweets";

  @Autowired
  RestTemplate restTemplate;
  @Autowired
  WebClient webclient;

  @GetMapping(value = { "", "/" })
  public String index() {
    return "this is rest client ex home";
  }

  @GetMapping(value = { "blocking" })
  public String getProfileBlocking() {
    log.info("Starting BLOCKING Controller!");

    // RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<String>() {
        });

    String result = response.getBody();
    // result.forEach(tweet -> log.info(tweet.toString()));
    log.info("Exiting BLOCKING Controller!");
    return result;

  }

  @GetMapping(value = { "blocking2" })
  public @ResponseBody List<Tweet> getTweetsBlocking() {
    log.info("Starting BLOCKING Controller!");

    // RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Tweet>> response = restTemplate.exchange("http://localhost:8080/tweet", HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Tweet>>() {
        });

    List<Tweet> result = response.getBody();
    // result.forEach(tweet -> log.info(tweet.toString()));
    log.info("Exiting BLOCKING Controller!");
    return result;

  }

  @GetMapping(value = { "nonblocking" })
  public @ResponseBody Flux<String> getTweetsNonBlocking() {
    log.info("Starting NON-BLOCKING Controller!");
    Flux<String> flux = webclient.get().uri(uri).retrieve().bodyToFlux(String.class);

    // tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
    log.info("Exiting NON-BLOCKING Controller!");
    return flux;

  }

  @GetMapping(value = { "nonblocking2" })
  public String getTweetsNonBlocking2() {
    log.info("Starting NON-BLOCKING Controller!");
    String profile = webclient.get().uri(uri).retrieve().bodyToMono(String.class).block();

    // tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
    log.info("Exiting NON-BLOCKING Controller!");
    return profile;

  }

}
