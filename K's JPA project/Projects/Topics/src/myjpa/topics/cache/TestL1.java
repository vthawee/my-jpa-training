package myjpa.topics.cache;

import javax.persistence.*;

public class TestL1 {

    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicsPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Book b0 = new Book("Football");
        em.persist(b0);
        em.flush();
        em.getTransaction().commit();

        Book b1 = em.find(Book.class, b0.getId());

        System.out.println(b0 == b1);
    }
}
