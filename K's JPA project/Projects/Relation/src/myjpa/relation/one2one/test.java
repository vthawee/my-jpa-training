/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.relation.one2one;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author com
 */
public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelationPU");

        EntityManager em = emf.createEntityManager();

        //Add
//        StockDetail stockDetail = new StockDetail("TEST7", "TEST7");
//        Stock stock = new Stock("TEST7", "TEST7", stockDetail);
//
//        stockDetail.setStock(stock);
//
//        em.getTransaction().begin();
//        em.persist(stock);
//        em.persist(stockDetail);
//        em.getTransaction().commit();
        //Remove
//        Stock stock2 = em.find(Stock.class, 1);
//
//        em.getTransaction().begin();
//        em.remove(stock2);
//        em.getTransaction().commit();
        //Show
        String jpql = "select s from Stock s join fetch s.stockDetail";

        List<Stock> stockList = em.createQuery(jpql, Stock.class).getResultList();

        for (Stock showStock : stockList) {
            System.out.println(showStock);
        }
    }

}
