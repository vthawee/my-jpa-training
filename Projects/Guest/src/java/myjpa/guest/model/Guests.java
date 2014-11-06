/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.guest.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object (DAO) for Guest Entity
 *
 * @author com
 */
@Repository
public class Guests {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int insert(Guest g) {
        em.persist(g);
        em.flush();
        return g.getId();
    }

    public List<Guest> findAll() {
//        return findAllNativeQuery();
        return findAll(0, Integer.MAX_VALUE);
    }

    private List<Guest> findAllNativeQuery() {
        String sql = "SELECT * FROM guest";
        Query nativeQuery = em.createNativeQuery(sql, Guest.class);

        return nativeQuery.getResultList();
    }

    private Query getJpqlQuery() {
        String jpql = "SELECT g FROM Guest g";
        Query query = em.createQuery(jpql);
        return query;
    }

    public List<Guest> findAll(int start, int size) {

        Query query = getJpqlQuery();
        query.setFirstResult(start);
        query.setMaxResults(size);

        return query.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("SELECT count(g) FROM Guest g").getSingleResult()).intValue();
    }
}
