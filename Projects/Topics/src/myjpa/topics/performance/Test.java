package myjpa.topics.performance;

import javax.persistence.*;

public class Test {

    public static void main(String[] args) {
//        System.gc();
//        Runtime.getRuntime().freeMemory();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicsPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        for (int i = 0; i < 100000; i++) {

            em.persist(new Text("hello"));

            if (i % 100 == 0) {
                em.flush(); // flush 
                //em.clear(); // Must try
            }
        }
        tx.commit();
        
        em.close();
    }
}
