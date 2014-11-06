package myjpa.features.inheritance.perclass;

import java.io.*;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Product3 implements Serializable {
  @Id 
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String name;
  private int price;

  public Product3() {
  }

  public Product3(String name, int price) {
    this.name = name;
    this.price = price;
  }
  
  public Product3(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 17 * hash + this.id;
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
    final Product3 other = (Product3) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Product3{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
  }
}