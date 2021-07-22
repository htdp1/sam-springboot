package net.kubepia.sam.container;

import org.springframework.stereotype.Component;

@Component("soccerBall")
public class SoccerBall implements Ball {
  public String touchBall() {
    return "축구공이 굴러간다";
  }
}
