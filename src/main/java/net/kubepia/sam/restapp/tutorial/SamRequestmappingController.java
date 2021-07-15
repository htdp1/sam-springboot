package net.kubepia.sam.restapp.tutorial;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(path = "request") // root reqeust path, define in value="" or path=""
@Slf4j
public class SamRequestmappingController {


  // Logger logger = LoggerFactory.getLogger(SamRequestmappingController.class);

  

  // http://domain/request, http://domain/request/
  @GetMapping("")
  public String index() {
    log.info("request home called");
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

  /*
   * curl --location --request PUT 'http://localhost:8080/request/methods' \
   *  --header 'Content-Type: application/json' \
   *  --data-raw '{ .. }'
   */
  @PutMapping("/methods")
  public String putMethod() {
    return "this is \"Put\" method\n";
  }

  /*
   * curl --location --request DELETE 'http://localhost:8080/request/methods' \
   *  --header 'Content-Type: application/json' \
   *  --data-raw '{ .... }'
   */
  @DeleteMapping("/methods")
  public String deleteMethod() {
    return "this is \"Delete\" method\n";  
  }

  @GetMapping(value="/reg/{major:[vV][0-9]+}-{minor:[0-9]+}")
  public String getRegularExp(@PathVariable String major, @PathVariable String minor) {
      return "version:"+major+"-"+minor+"\n";
  }


}
