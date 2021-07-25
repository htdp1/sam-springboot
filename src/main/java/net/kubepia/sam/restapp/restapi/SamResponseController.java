package net.kubepia.sam.restapp.restapi;

import java.nio.charset.Charset;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "output")
@Slf4j
public class SamResponseController {

  @Autowired
  private TodoList todos;

  // Response String
  @GetMapping(value = "string")
  public String handleString() {
    log.info("response data as string");
    log.info(Charset.defaultCharset().displayName());
    return "This is sample response as 문자열\n";
  }

  // Response json using object
  @GetMapping({ "todo/{id}", "todo" })
  public @ResponseBody TodoItem getTodo(@PathVariable(required = false) Integer id) throws Exception {
    // int id = todoId.get();
    if (null == id)
      return null;

    log.info("id:{}, name:{}", id);
    for (TodoItem todoItem : todos) {
      if (id == todoItem.getId()) {
        return todoItem;
      }
    }
    // throw new Exception("Cannot find todo item " + id);
    return null;
  }

  // Response json using object with cookie
  @GetMapping({ "cookie/{id}", "cookie" })
  public @ResponseBody TodoItem setCookie(@PathVariable(required = false) Integer id, HttpServletResponse response)
      throws Exception {
    id = id == null ? 0 : id;
    Cookie cookie = new Cookie("jwt-token", "value123456789");
    cookie.setMaxAge(86400);
    cookie.setSecure(true);
    cookie.setHttpOnly(true);
    cookie.setPath("/user/");
    cookie.setDomain("example.com");
    response.addCookie(cookie);
    return todos.getFirst();
  }

  // Response json using object with header
  @GetMapping({ "header/{id}", "header" })
  public @ResponseBody TodoItem setHeader(@PathVariable(required = false) Integer id, HttpServletResponse response)
      throws Exception {
    id = id == null ? 0 : id;
    response.setHeader("biz-key", "value123456789");

    return todos.getFirst();
  }

  // Response json using object with specific status code
  @GetMapping({ "status/{id}", "status" })
  public @ResponseBody TodoItem setStatus(@PathVariable(required = false) Integer id, HttpServletResponse response)
      throws Exception {
    id = id == null ? 200 : id;
    response.setStatus(id);

    return todos.getFirst();
  }
}
