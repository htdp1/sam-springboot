package net.kubepia.sam.restapp.tutorial;

import java.nio.charset.Charset;

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
  @GetMapping(value="string", produces = "text/plain;charset=utf-8")
  public String handleString(){
    log.info("response data as string");
    log.info(Charset.defaultCharset().displayName());
    return "{\"key\":\"hello 문자열\"}";
  }

  //Response json using object
  @GetMapping({"todo/{id}", "todo"})
  public @ResponseBody TodoItem getTodo(@PathVariable(required = false) Integer id) throws Exception{
    log.info("id:{}",id);
    for (TodoItem todoItem : todos) {
      if(id == todoItem.getId()){
        return todoItem;
      }
    }
    throw new Exception("Cannot find todo item "+id);
    // return null;
  }
}
