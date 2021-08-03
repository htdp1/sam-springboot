package net.kubepia.sam.restapp.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Slf4j
@RequestMapping("tweet")
public class TweetController {

  @GetMapping(value = { "", "/" })
  private List<Tweet> getAllTweets() throws Exception {
    Thread.sleep(100L); // delay
    return Arrays.asList(new Tweet("RestTemplate rules", "@user1"), new Tweet("WebClient is better", "@user2"),
        new Tweet("OK, both are useful", "@user1"));
  }
}
