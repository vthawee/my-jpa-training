/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.topics.concurrent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

/**
 *
 * @author com
 */
public class TestPessimistic {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicsPU");
        EntityManager emMain = emf.createEntityManager();
        // Add
//        Account acc = new Account(10000);
//        
//        emMain.getTransaction().begin();
//        emMain.persist(acc);
//        emMain.getTransaction().commit();

        // Concurrent
        new Thread(() -> {
            // Each thread should has its own EntityManager
            EntityManager em = emf.createEntityManager();
            for (int i = 0; i < 100; i++) {
                change(em, 10);
            }
            em.close();
        }).start();

        new Thread(() -> {
            // Each thread should has its own EntityManager
            EntityManager em = emf.createEntityManager();

            for (int i = 0; i < 100; i++) {
                change(em, -10);
            }
            em.close();
        }).start();

    }

    private static boolean change(EntityManager em, int diff) {

        em.getTransaction().begin();

        Account acc = em.find(Account.class, 3);
        em.lock(acc, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
        acc.setBalance(acc.getBalance() + diff);
        //System.out.println("increse: " + i +  ", balance :" + acc.getBalance());

        em.getTransaction().commit();
        return true;
    }
}
