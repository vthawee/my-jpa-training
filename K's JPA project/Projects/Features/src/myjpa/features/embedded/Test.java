package myjpa.features.embedded;

import java.util.*;
import javax.persistence.*;

public class Test {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("FeaturesPU").createEntityManager();

        //  Add
        Address address = new Address(null, "Bangkok", "10000");
        Student student = new Student("Sompong", "Kongdee", address);

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        //  Show
        String jpql = "SELECT s FROM Student AS s";
        Query query = em.createQuery(jpql);

        for (Student s : (List<Student>) query.getResultList()) {
            System.out.println(s);
        }
    }
}
