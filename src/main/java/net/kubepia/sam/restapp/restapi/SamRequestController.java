package net.kubepia.sam.restapp.restapi;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "input")
@Slf4j
public class SamRequestController {

  public SamRequestController() {
    log.info("SamRequestController constructor");
  }

  // Logger logger = LoggerFactory.getLogger(SamReqInputController.class);

  /*
   * RequestHeader curl --location --request GET 'localhost:8080/input/header'
   */
  @GetMapping("header")
  public String handleHeader(@RequestHeader("Accept") String accept,
      @RequestHeader(value = "Keep-Alive", required = false, defaultValue = "300") long keepAlive) {

    return "Header => Accept:" + accept + ",Keep-Alive:" + keepAlive + "\n";
  }

  @GetMapping("headers")
  @ResponseStatus(value = HttpStatus.OK)
  public void allHeaders(@RequestHeader Map<String, String> headers) {

    log.info("All headers:{}", headers);
  }

  // curl -v --cookie "USER=SK" http://localhost:8080/input/cookie
  @GetMapping("cookie")
  @ResponseStatus(HttpStatus.OK)
  public void handleCookie(@CookieValue("USER") String user) {
    log.info("Cookie User:{}", user);
  }

  /*
   * curl --location --request GET
   * 'localhost:8080/input/param?name=sk%EB%A7%A8&age=30'
   */
  @GetMapping("param")
  public String handleQueryString(@RequestParam("name") String name, @RequestParam("age") int age) {
    String msg = "name :" + name + ",age:" + age + "\n";
    log.info(msg);
    return msg;
  }

  /*
   * curl --location --request POST 'localhost:8080/input/body' \ --header
   * 'Content-Type: application/json' \ --data-raw '{ "title":"제목",
   * "description":"설명" }'
   */
  @PostMapping("body")
  public @ResponseBody TodoItem handleRequestBody(@RequestBody TodoItem todo) {
    // todo.setTitle(todo.getTitle()+"-return");
    log.info(todo.toString());
    return todo;
  }

  /*
   * curl --location --request POST 'localhost:8080/input/form' \ --form
   * 'title="제목 값"' \ --form 'description="설명입력값"'
   */
  @PostMapping(value = "form", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody String handleRequestForm(@RequestParam("title") String title,
      @RequestParam("description") String description) {

    return "{ \"title\":" + title + ", \"description\":" + description + "}\n";
  }

}
