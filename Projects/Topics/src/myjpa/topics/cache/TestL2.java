package myjpa.topics.cache;

import java.util.*;
import javax.persistence.*;

public class TestL2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicsPU");
        EntityManager em = emf.createEntityManager();

        /**
         * Selective caching is enabled by
         * <shared-cache-element>ENABLE_SELECTIVE</shared-cache-element> and the
         * book entity is marked @Cachable(true)
         */
        em.getTransaction().begin();
        Book book0 = new Book("Some book");
        Book book1 = new Book("Another book");
        em.persist(book0);
        em.persist(book1);
        em.getTransaction().commit();

        Cache cache = emf.getCache();
        System.out.println(cache.contains(Book.class, book0.getId())); // true because it is in cache L2.
        System.out.println(cache.contains(Book.class, book1.getId()));

        Book cachedBook = em.find(Book.class, book0.getId());
        System.out.println(cachedBook == book0);

        cache.evict(Book.class, book0.getId()); // clear one designated book from cache
        System.out.println(cache.contains(Book.class, book0.getId()));

        cache.evict(Book.class); // clear all books from cache
        System.out.println(cache.contains(Book.class, book1.getId()));
        System.out.println("-------------------------------------------------------");

        /**
         * Selective caching is enabled by
         * <shared-cache-element>ENABLE_SELECTIVE</shared-cache-element> and the
         * people entity is marked @Cachable(false)
         */
        em.getTransaction().begin();
        People people0 = new People("Lisa");
        People people1 = new People("Tim");
        em.persist(people0);
        em.persist(people1);
        em.getTransaction().commit();

        Cache cache2 = emf.getCache();
        System.out.println(cache2.contains(People.class, people0.getId()));
        System.out.println(cache2.contains(People.class, people1.getId()));

        People personFound = em.find(People.class, people0.getId());
        System.out.println(personFound == people0);
        System.out.println("-------------------------------------------------------");

        /*
         * javax.persistence.retrieveMode
         * - BYPASS: The cache is bypassed and a call to the database is used to retrieve the data.
         * - USE: If the data is available in the cache, it is read from this location, else it is fetched from the database
         *
         * javax.persistence.storeMode
         * - BYPASS: Don’t put anything into the cache
         * - REFRESH: Data is put/updated in the cache when read and committed into the database a refresh enforced
         * - USE: Data is put/updated in the cache when read and committed into the database    
         */
        //  Store Mode
        em.getTransaction().begin();
        Book book2 = new Book("Book 1");
        Book book3 = new Book("Book 2");
        em.persist(book2);
        em.persist(book3);
        em.getTransaction().commit();

        Cache cache3 = emf.getCache();
        cache3.evictAll(); // clear the whole cache
        System.out.println(cache3.contains(Book.class, book2.getId()));

        Map<String, Object> props = new HashMap<>();
        props.put("javax.persistence.cache.storeMode", "REFRESH");
        em.find(Book.class, book2.getId(), props);
        System.out.println(cache3.contains(Book.class, book2.getId())); // now a cache,  get true

        cache3.evictAll(); // clear cache
        props.put("javax.persistence.cache.storeMode", "BYPASS"); // no cache
        em.find(Book.class, book2.getId(), props);
        System.out.println(cache3.contains(Book.class, book2.getId())); // no cache entry, get false
        
        props.put("javax.persistence.cache.storeMode", "REFRESH");
        em.find(People.class, people0.getId(), props);
        System.out.println(cache3.contains(People.class, people0.getId())); // false, People is not Cachable
        
    }
}
