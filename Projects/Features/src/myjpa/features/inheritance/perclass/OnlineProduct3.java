package myjpa.features.inheritance.perclass;

import java.util.*;
import javax.persistence.*;

@Entity
public class OnlineProduct3 extends Product3 {
  private String url;

  public OnlineProduct3() {
  }

  public OnlineProduct3(String name, int price, String url) {
    super(name, price);
    this.url = url;
  }
  
  public OnlineProduct3(int id, String name, int price, String url) {
    super(id, name, price);
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public int hashCode() {
    int hash = super.hashCode();
    hash = 59 * hash + Objects.hashCode(this.url);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final OnlineProduct3 other = (OnlineProduct3) obj;
    if (!Objects.equals(this.url, other.url)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return super.toString() + ", OnlineProduct3{" + "url=" + url + '}';
  }
}