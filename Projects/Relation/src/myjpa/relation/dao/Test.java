/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.relation.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import myjpa.relation.one2many.Artist;
import myjpa.relation.one2many.Song;

/**
 *
 * @author com
 */
public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelationPU");
        EntityManager em = emf.createEntityManager();
        
        ArtistDAO<Artist> dao = new ArtistDAO(emf, Artist.class);

        //System.out.println(dao.find(2));
//        List<Artist> artists = dao.findAll();
//        
//        artists.stream().forEach((a) -> {
//            System.out.println(a);
//            System.out.println("Song size: " + a.getSongs().size());
//        });
        System.out.println("Artist count: " + dao.count());

        //Add
//        Song songA = new Song("Song A");
//        Song songB = new Song("Song B");
//        Song songC = em.find(Song.class, 15);
//        Artist artist = new Artist("Stamp4");
//
//        artist.getSongs().add(songA);
//        artist.getSongs().add(songB);
//        artist.getSongs().add(songC);
//        
//        dao.create(artist);
//        
//        System.out.println("Artist count: " + dao.count());
        
        dao.destroy(100);
    }
}
