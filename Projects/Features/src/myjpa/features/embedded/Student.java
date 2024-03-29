package myjpa.features.embedded;

import java.io.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Student implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String surname;
  @Embedded
  @NotNull
  @Valid
  private Address address;

  public Student() {
  }
  
  public Student(String name, String surname, Address address) {
    this.name = name;
    this.surname = surname;
    this.address = address;
  }

  public Student(int id, String name, String surname, Address address) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.address = address;
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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 23 * hash + this.id;
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
    final Student other = (Student) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name=" + name + ", surname=" + surname 
           + ", address=" + address + '}';
  }
}