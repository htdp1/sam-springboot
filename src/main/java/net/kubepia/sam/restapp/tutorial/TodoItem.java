package net.kubepia.sam.restapp.tutorial;

import java.io.Serializable;
import java.util.Random;

/**
 * TodoItem
 */
public class TodoItem implements Serializable{
  private int id;
  
  private String title;
  private String description;
  
  public TodoItem(int id,String title, String description){
    this.id = id;
    this.title=title;
    this.description=description;
  }

  public TodoItem(){
    this.id=new Random().nextInt();
    this.title="제목";
    this.description="설명";
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  
}