package net.kubepia.sam.restapp.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "request") // root reqeust path, define in value="" or path=""
public class SamRequestmappingController {

  Logger logger = LoggerFactory.getLogger(SamRequestmappingController.class);

  // http://domain/request, http://domain/request/
  @GetMapping("")
  public String index() {
    logger.trace("request home called");
    return "request home";
  }

  @RequestMapping(path="reqmapping", method=RequestMethod.GET)
  public String getMapping(){
    return "get method using RequestMapping\n";
  }

  @RequestMapping(value="default")
  public String defaultMapping(){
    return "all method using RequestMapping\n";
  }

  /*
   * curl --location --request GET \
   * 'http://localhost:8080/request/methods'
   */
  @GetMapping("/methods")
  public String getMethod() {
    return "this is \"Get\" method\n";
  }

  /*
   * curl --location --request POST 'http://localhost:8080/request/methods' \
   *  --header 'Content-Type: application/json' \
   *  --data-raw '{ .. }'
   */
  @PostMapping("/methods")
  public String postMethod() {
    return "this is \"Post\" method\n";
  }

  @PutMapping("/methods")
  public String putMethod() {
    return "this is \"Put\" method\n";
  }

  @DeleteMapping("/methods")
  public String deleteMethod() {
    return "this is \"Delete\" method\n";
  }

}
