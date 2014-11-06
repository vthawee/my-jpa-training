package myjpa.features.callback;

import javax.persistence.*;

public class PersonListener {
  @PostLoad
  public void postLoad(Person p) {
    System.out.println("Post Load: " + p);
  }
  
  @PrePersist
  public void prePersist(Person p) {
    System.out.println("Pre Persist: " + p);
  }
  
  @PostPersist
  public void postPersist(Person p) {
    System.out.println("Post Persist: " + p);
  }
  
  @PreUpdate
  public void preUpdate(Person p) {
    System.out.println("Pre Update: " + p);
  }
  
  @PostUpdate
  public void postUpdate(Person p) {
    System.out.println("Post Update: " + p);
  }
  
  @PreRemove
  public void preRemove(Person p) {
    System.out.println("Pre Remove: " + p);
  }
  
  @PostRemove
  public void postRemove(Person p) {
    System.out.println("Post Remove: " + p);
  }
}