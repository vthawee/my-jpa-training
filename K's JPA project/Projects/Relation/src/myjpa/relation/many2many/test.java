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
public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelationPU");

        EntityManager em = emf.createEntityManager();

        //Add
//        Actor actor1 = new Actor("actor1");
//        Actor actor2 = new Actor("actor2");
//
//        Movie movie1 = new Movie("movie1");
//        Movie movie2 = new Movie("movie2");
//
//        actor1.getMovies().add(movie1);
//        actor1.getMovies().add(movie2);
//        actor2.getMovies().add(movie2);
//
//        movie1.getActors().add(actor1);
//        movie2.getActors().add(actor1);
//        movie2.getActors().add(actor2);
//
//        em.getTransaction().begin();
//        em.persist(movie1);
//        em.persist(movie2);
//        em.persist(actor1);
//        em.persist(actor2);
//        em.getTransaction().commit();
        //Show
//        String jpql = "select distinct a from Actor a join fetch a.movies";
//        List<Actor> actorList = em.createQuery(jpql, Actor.class).getResultList();
//
//        for (Actor actor : actorList) {
//            System.out.println(actor);
//        }
        String jpql = "select distinct m from Movie m join fetch m.actors";
        List<Movie> movieList = em.createQuery(jpql, Movie.class).getResultList();

        for (Movie movie : movieList) {
            System.out.println(movie);
        }

    }
}
