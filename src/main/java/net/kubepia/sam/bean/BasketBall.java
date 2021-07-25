package net.kubepia.sam.bean;

import org.springframework.stereotype.Component;

@Component("basketBall")
public class BasketBall implements Ball {
  public BasketBall() {
    System.out.println("basketball created by constructor");
  }

  public String touchBall() {
    return "농구공이 굴러간다";
  }
}