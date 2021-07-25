package net.kubepia.sam.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("soccerBall")
public class SoccerBall implements Ball {
  public SoccerBall() {
    System.out.println("soccerBall created by constructor");
  }

  public String touchBall() {
    return "축구공이 굴러간다";
  }

  @PostConstruct
  public void init() {
    System.out.println("socckerball init");
  }

  @PreDestroy
  public void close() {
    System.out.println("socckerball destroy");
  }
}
