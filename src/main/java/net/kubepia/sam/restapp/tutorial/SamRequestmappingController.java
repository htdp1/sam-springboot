package net.kubepia.sam.restapp.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tutorial") // root reqeust path, define in value="" or path=""
public class SamRequestmappingController {

  Logger logger = LoggerFactory.getLogger(SamRequestmappingController.class);

  // http://domain/tutorial, http://domain/tutorial/
  @GetMapping("")
  public String index() {
    logger.trace("A TRACE Message");
    logger.debug("A DEBUG Message");
    logger.info("An INFO Message");
    logger.warn("A WARN Message");
    logger.error("An ERROR Message");
    return "tutorial home";
  }

}
