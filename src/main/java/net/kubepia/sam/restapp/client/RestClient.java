package net.kubepia.sam.restapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("rest")
public class RestClient {

  @Autowired
  @Qualifier("randomProfile")
  WebClient clientRandom;
  @Autowired
  @Qualifier("tweet")
  WebClient clientTweet;

  @GetMapping("randomprofile")
  public Mono<String> getProfile() {
    log.info("calling external api");
    return this.clientRandom.get().uri("/api").retrieve().bodyToMono(String.class);
  }

  @GetMapping("randomprofile2")
  public Mono<String> getProfile2() {
    log.info("calling external api");
    return this.clientRandom.get().uri("/api").retrieve().bodyToMono(String.class);
  }

  @GetMapping("tweets")
  public Flux<Tweet> getTweets() {
    log.info("calling external api");
    return this.clientTweet.get().uri("").retrieve().bodyToFlux(Tweet.class);
  }

}
