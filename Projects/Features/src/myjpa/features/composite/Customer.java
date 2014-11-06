package myjpa.features.composite;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
@IdClass(CustomerId.class)
public class Customer implements Serializable {
  @Id
  private String name;
  @Id
  private String surname;
  private String street;
  private String province;

  public Customer() {
  }

  public Customer(String name, String surname, String street, String province) {
    this.name = name;
    this.surname = surname;
    this.street = street;
    this.province = province;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.name);
    hash = 89 * hash + Objects.hashCode(this.surname);
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
    final Customer other = (Customer) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.surname, other.surname)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Customer{" + "name=" + name + ", surname=" + surname 
           + ", street=" + street + ", province=" + province + '}';
  }
}