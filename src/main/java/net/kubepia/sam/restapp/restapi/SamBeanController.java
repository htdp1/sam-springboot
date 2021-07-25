package net.kubepia.sam.restapp.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "bean")
@Slf4j
public class SamBeanController {
  @Autowired
  @Qualifier("samcomponent")
  private SamComponent myComponent;

  @GetMapping("")
  public String index() {
    log.info("request bean home called");

    return this.myComponent.method();
  }

  @GetMapping(value = "/usage")
  public String getMethodName(@Autowired @Qualifier("samcomponent") SamComponent comp) {
    return comp.method();
  }

}
