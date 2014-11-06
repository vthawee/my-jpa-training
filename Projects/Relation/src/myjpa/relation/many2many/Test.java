/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.relation.many2many;

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

        // Add
//        Movie movie0 = new Movie("Movie A3");
//        Movie movie1 = new Movie("Movie B3");
//
//        Actor actor0 = new Actor("Moon");
//        Actor actor1 = new Actor("Brown");
//
//        actor0.getMovies().add(movie0);
//        actor0.getMovies().add(movie1);
//        actor1.getMovies().add(movie1);
//
//        movie0.getActors().add(actor0);
//        movie1.getActors().add(actor0);
//        movie1.getActors().add(actor1);
//
//        em.getTransaction().begin();
//        em.persist(movie0);
////        em.persist(movie1);
////        em.persist(actor0);
////        em.persist(actor1);
//        em.getTransaction().commit();

        // Show
        String jpql = "SELECT a FROM Actor a JOIN FETCH a.movies";
        List<Actor> actors = em.createQuery(jpql, Actor.class).getResultList();

        actors.stream().forEach((a) -> {
            System.out.println(a);
        });
        
        Movie movieId2 = em.find(Movie.class, 2);
        System.out.println(movieId2);
    }
}
