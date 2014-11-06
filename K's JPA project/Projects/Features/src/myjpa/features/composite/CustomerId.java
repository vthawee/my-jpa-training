package myjpa.features.composite;

import java.io.*;
import java.util.*;

public class CustomerId implements Serializable {
  private String name;
  private String surname;

  public CustomerId() {
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + Objects.hashCode(this.name);
    hash = 61 * hash + Objects.hashCode(this.surname);
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
    final CustomerId other = (CustomerId) obj;
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
    return "CustomerId{" + "name=" + name + ", surname=" + surname + '}';
  }
}