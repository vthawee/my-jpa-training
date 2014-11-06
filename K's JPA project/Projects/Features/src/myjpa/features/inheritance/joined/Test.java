package myjpa.features.inheritance.joined;

import java.util.*;
import javax.persistence.*;

public class Test {
  public static void main(String[] args) {
    EntityManager em = Persistence.createEntityManagerFactory("FeaturesPU").createEntityManager();

    //  Add
    Product2 p0 = new Product2("Cartoon", 45);
    Product2 p1 = new OnlineProduct2("Gunpla", 450, "http://gundum.com");
    
    em.getTransaction().begin();
    em.persist(p0);
    em.persist(p1);
    em.getTransaction().commit();
    
    //  Show
    String jpql = "SELECT p FROM OnlineProduct2 AS p";
    Query query = em.createQuery(jpql);
    
    for (Product2 s : (List<Product2>) query.getResultList()) {
      em.refresh(s);  //  For Type of the new Entity

      System.out.println(s);
    }
  }
}