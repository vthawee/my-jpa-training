package myjpa.topics.performance;

import javax.persistence.*;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicsPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        for (int i = 0; i < 100000; i++) {

            em.persist(new Text("hello"));

            System.gc();
            if (i % 100 == 0) {
                em.flush();
                em.clear();
                System.out.println(Runtime.getRuntime().freeMemory());
            }

        }
        tx.commit();
    }
}
