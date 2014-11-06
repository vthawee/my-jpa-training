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
public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelationPU");
        EntityManager em = emf.createEntityManager();

        // ADD
//        StockDetail stockDetail = new StockDetail("Con", "Super Service");
//        Stock stock = new Stock("ABC7", "Food", stockDetail);
//        stockDetail.setStock(stock);
//
//        em.getTransaction().begin();
//        em.persist(stock);
//        em.getTransaction().commit();

        // REMOVE
//        em.getTransaction().begin();
//        Stock s3 = em.find(Stock.class, 4);
//        em.remove(s3);
//        em.getTransaction().commit();
        
        String jpql = "SELECT s FROM Stock s";
        List<Stock> stocks = em.createQuery(jpql, Stock.class).getResultList();
        
        stocks.stream().forEach((s) -> {
            System.out.println(s);
        });
    }
}
