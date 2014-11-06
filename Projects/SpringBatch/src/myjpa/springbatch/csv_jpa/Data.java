package myjpa.springbatch.csv_jpa;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Data implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private int value;
  private double digit;
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  public Data() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public double getDigit() {
    return digit;
  }

  public void setDigit(double digit) {
    this.digit = digit;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.name);
    hash = 89 * hash + this.value;
    hash = 89 * hash + (int) (Double.doubleToLongBits(this.digit) 
                              ^ (Double.doubleToLongBits(this.digit) >>> 32));
    hash = 89 * hash + Objects.hashCode(this.date);
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
    final Data other = (Data) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (this.value != other.value) {
      return false;
    }
    if (Double.doubleToLongBits(this.digit) != Double.doubleToLongBits(other.digit)) {
      return false;
    }
    if (!Objects.equals(this.date, other.date)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Data{" + "name=" + name + ", value=" + value + ", digit=" + digit 
           + ", date=" + date + '}';
  }
}