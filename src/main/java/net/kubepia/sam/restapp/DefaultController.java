package net.kubepia.sam.restapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultController {

  @GetMapping("/")
  public String index() {
    log.info("Home called !");
    return "This is Home";
  }
}
