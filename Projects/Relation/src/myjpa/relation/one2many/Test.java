/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.relation.one2many;

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

        //Add
        Song songA = new Song("Song A");
        Song songB = new Song("Song B");
        Song songC = new Song("Song C");
        Artist artist = new Artist("Stamp3");
//        Artist artist = em.find(Artist.class, 1);
        
        artist.getSongs().add(songA);
        artist.getSongs().add(songB);
        artist.getSongs().add(songC);
        
        songA.setArtist(artist);
        songB.setArtist(artist);
        songC.setArtist(artist);
        
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        
        
        // REMOVE
//        em.getTransaction().begin();
//        Artist removeArtist= em.find(Artist.class, 2);
//        em.remove(removeArtist);
//        em.getTransaction().commit();
        
        
        // Show
//        String jpql = "SELECT a FROM Artist a";
        /* Use JOIN FETCH in jpql to select all in one query */
//        String jpql = "SELECT DISTINCT a FROM Artist a JOIN FETCH a.songs";
//        List<Artist> artists = em.createQuery(jpql, Artist.class).getResultList();
//
//        artists.stream().forEach((a) -> {
//            System.out.println(a);
//            System.out.println("Song size: " + a.getSongs().size());
//        });
        
//        String jpql2 = "SELECT s FROM Song s";
//        List<Song> songs = em.createQuery(jpql2, Song.class).getResultList();
//
//        songs.stream().forEach((s) -> {
//            System.out.println(s);
//        });

    }


}
