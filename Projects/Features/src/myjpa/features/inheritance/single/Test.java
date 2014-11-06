package myjpa.features.inheritance.single;

import java.util.*;
import javax.persistence.*;

public class Test {
  public static void main(String[] args) {
    EntityManager em = Persistence.createEntityManagerFactory("FeaturesPU").createEntityManager();

    //  Add
//    Product p0 = new Product("Cartoon", 45);
//    Product p1 = new OnlineProduct("Gunpla", 450, "http://gundum.com");
//    
//    em.getTransaction().begin();
//    em.persist(p0);
//    em.persist(p1);
//    em.getTransaction().commit();
    
    //  Show
    String jpql = "SELECT p FROM OnlineProduct AS p";
    Query query = em.createQuery(jpql);
    
    for (Product s : (List<Product>) query.getResultList()) {
      em.refresh(s);  //  For Type of the new Entity

      System.out.println(s);
    }
  }
}