package net.kubepia.sam.restapp.restapi;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("samcomponent")
@Slf4j
public class SamComponent {
  public String method() {
    log.info("component called");
    return "This is sample @Component";
  }
}
