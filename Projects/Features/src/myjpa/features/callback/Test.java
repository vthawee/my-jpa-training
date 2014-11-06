package myjpa.features.callback;

import java.util.*;
import javax.persistence.*;

public class Test {
  public static void main(String[] args) {
    EntityManager em = Persistence.createEntityManagerFactory("FeaturesPU").createEntityManager();

    //  Add
    Person person = new Person("Somying", "Jaidee2");
    
    em.getTransaction().begin();
    em.persist(person);
    em.getTransaction().commit();
    
    //  Show
    String jpql = "SELECT p FROM Person AS p";
    Query query = em.createQuery(jpql);

    for (Person c : (List<Person>) query.getResultList()) {
      System.out.println(c);
    }
  }
}