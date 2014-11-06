package myjpa.features.inheritance.joined;

import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue("ONLINE")
@PrimaryKeyJoinColumn(name="PRODUCT_ID", referencedColumnName="ID")
public class OnlineProduct2 extends Product2 {
  private String url;

  public OnlineProduct2() {
  }

  public OnlineProduct2(String name, int price, String url) {
    super(name, price);
    this.url = url;
  }
  
  public OnlineProduct2(int id, String name, int price, String url) {
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
    final OnlineProduct2 other = (OnlineProduct2) obj;
    if (!Objects.equals(this.url, other.url)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return super.toString() + ", OnlineProduct2{" + "url=" + url + '}';
  }
}