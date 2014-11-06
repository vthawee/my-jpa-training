/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.guest.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object (DAO)
 *
 * @author com
 */
@Repository
public class Guests {

//Inject Entity manager
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int insert(Guest g) {

        em.persist(g);
        em.flush();

        return g.getId();
    }

    public int count() {
//        ((Long) em.createQuery("select count(g) from Guest g").getSingleResult()).intValue();

        return findAllByJpql().size();
    }

    public List<Guest> findWithInRange(int start, int size) {

        //JPQL
        String jpql = "select g from Guest g";
        List<Guest> guestList = em.createQuery(jpql)
                .setMaxResults(size)
                .setFirstResult(start)
                .getResultList();

        return guestList;
    }

    public List<Guest> findAllByNativeQuery() {

        //Native query
        String sql = "select * from guest";
        List<Guest> guestList = em.createNativeQuery(sql, Guest.class)
                .getResultList();

        return guestList;
    }

    public List<Guest> findAllByJpql() {

        //JPQL
        String jpql = "select g from Guest g";
        List<Guest> guestList = em.createQuery(jpql)
                .getResultList();

        return guestList;
    }

    public List<Guest> findAllByNameQuery() {

        //Name query
        List<Guest> guestList = em.createNamedQuery("Guest.findAll")
                .getResultList();

        return guestList;
    }

}
