package net.kubepia.sam.container;

import org.springframework.stereotype.Component;

@Component("basketBall")
public class BasketBall implements Ball {
  public String touchBall() {
    return "농구공이 굴러간다";
  }
}