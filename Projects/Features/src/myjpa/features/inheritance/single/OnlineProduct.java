package myjpa.features.inheritance.single;

import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue("ONLINE")
public class OnlineProduct extends Product {
  private String url;

  public OnlineProduct() {
  }

  public OnlineProduct(String name, int price, String url) {
    super(name, price);
    this.url = url;
  }
  
  public OnlineProduct(int id, String name, int price, String url) {
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
    final OnlineProduct other = (OnlineProduct) obj;
    if (!Objects.equals(this.url, other.url)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return super.toString() + ", OnlineProduct{" + "url=" + url + '}';
  }
}