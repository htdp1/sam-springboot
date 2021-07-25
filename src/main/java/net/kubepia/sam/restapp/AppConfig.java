package net.kubepia.sam.restapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import net.kubepia.sam.restapp.restapi.TodoItem;
import net.kubepia.sam.restapp.restapi.TodoList;

@Configuration
public class AppConfig {

  @Bean
  @Scope(value = "singleton")
  public TodoList todos() {
    TodoList list = new TodoList();
    for (int i = 0; i < 10; i++) {
      list.addLast(new TodoItem(i, "제목" + i, "description....."));
    }
    return list;
  }
}
