package net.kubepia.sam.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Player {
  @Autowired
  @Qualifier("soccerBall")
  private Ball ballA;
  @Autowired
  @Qualifier("basketBall")
  private Ball ballB;

  public void touch() {
    System.out.println(this.ballA.touchBall());
    System.out.println(this.ballB.touchBall());

  }

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.scan("net.kubepia.sam.container");
    context.refresh();
    Player player = context.getBean(Player.class);
    player.touch();
    context.close();
  }
}