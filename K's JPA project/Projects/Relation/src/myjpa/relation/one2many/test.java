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
public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelationPU");

        EntityManager em = emf.createEntityManager();

        //Add
//        Artist artist = new Artist("NO");
//
//        Song song1 = new Song("song1", artist);
//        Song song2 = new Song("song2", artist);
//
//        artist.getSongs().add(song1);
//        artist.getSongs().add(song2);
//
//        em.getTransaction().begin();
//        em.persist(artist);
//        em.getTransaction().commit();
        //Remove
//        Artist removeArtist = em.find(Artist.class, 2);
//
//        em.getTransaction().begin();
//        em.remove(removeArtist);
//        em.getTransaction().commit();
        //Show
//        String jpql = "select distinct a from Artist a join fetch a.songs";
//
//        List<Artist> artistList = em.createQuery(jpql, Artist.class).getResultList();
//
//        for (Artist showArtist : artistList) {
//            System.out.println(showArtist);
//        }
        String jpql = "select s from Song s";

        List<Song> songList = em.createQuery(jpql, Song.class).getResultList();

        for (Song showSong : songList) {
            System.out.println(showSong);
        }
    }

}
