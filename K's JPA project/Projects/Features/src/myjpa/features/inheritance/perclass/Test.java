package myjpa.features.inheritance.perclass;

import java.util.*;
import javax.persistence.*;

public class Test {
  public static void main(String[] args) {
    EntityManager em = Persistence.createEntityManagerFactory("FeaturesPU").createEntityManager();

    //  Add
    Product3 p0 = new Product3("Cartoon", 45);
    Product3 p1 = new OnlineProduct3("Gunpla", 450, "http://gundum.com");
    
    em.getTransaction().begin();
    em.persist(p0);
    em.persist(p1);
    em.getTransaction().commit();
    
    //  Show
    String jpql = "SELECT p FROM OnlineProduct3 AS p";
    Query query = em.createQuery(jpql);
    
    for (Product3 s : (List<Product3>) query.getResultList()) {
      em.refresh(s);  //  For Type of the new Entity

      System.out.println(s);
    }
  }
}