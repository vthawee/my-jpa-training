package myjpa.features.composite;

import java.util.*;
import javax.persistence.*;

public class Test {
  public static void main(String[] args) {
    EntityManager em = Persistence.createEntityManagerFactory("FeaturesPU").createEntityManager();

    //  Add
//    Customer cust = new Customer("Somying", "Jaidee", "Radumri", "Bangkok");
//    
//    em.getTransaction().begin();
//    em.persist(cust);
//    em.getTransaction().commit();
    
    //  Show
    String jpql = "SELECT c FROM Customer AS c";
    Query query = em.createQuery(jpql);

    for (Customer c : (List<Customer>) query.getResultList()) {
      System.out.println(c);
    }
  }
}