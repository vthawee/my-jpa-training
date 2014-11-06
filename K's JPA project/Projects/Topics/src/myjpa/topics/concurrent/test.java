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

public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicsPU");
//        EntityManager em = emf.createEntityManager();

        //Add
//        Account account = new Account(10000);
//
//        em.getTransaction().begin();
//
//        em.persist(account);
//
//        em.getTransaction().commit();
        new Thread(() -> {
            EntityManager em = emf.createEntityManager();

            for (int i = 0; i < 100; i++) {
                em.getTransaction().begin();

                Account account = em.find(Account.class, 1);
                em.lock(account, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
                account.setBalance(account.getBalance() + 10);

                em.getTransaction().commit();
//                try {
//                    em.getTransaction().commit();
//                } catch (Exception e) {
//                    i--;
//                }
            }

            em.close();
        }).start();

        new Thread(() -> {
            EntityManager em = emf.createEntityManager();

            for (int i = 0; i < 100; i++) {
                em.getTransaction().begin();

                Account account = em.find(Account.class, 1);
                em.lock(account, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
                account.setBalance(account.getBalance() - 10);

                em.getTransaction().commit();
//                try {
//                    em.getTransaction().commit();
//                } catch (Exception e) {
//                    i--;
//                }
            }

            em.close();
        }).start();
    }

}
