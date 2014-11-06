/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.relation.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import myjpa.relation.one2many.Artist;
import myjpa.relation.one2many.Song;

/**
 *
 * @author com
 */
public class test {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelationPU");
        
        EntityManager em = emf.createEntityManager();
        
        ArtistDAO artistDAO = new ArtistDAO(emf);

        //Add
//        Artist artist = new Artist("NO");
//
//        Song song1 = new Song("song1");
//        Song song2 = em.find(Song.class, 9);
//
//        artist.getSongs().add(song1);
//        artist.getSongs().add(song2);
//
//        artistDAO.create(artist);
        //Remove
        artistDAO.destroy(8);

        //find
        System.out.println(artistDAO.find(3));
        System.out.println(artistDAO.findAll());
        System.out.println(artistDAO.count());
        
    }
    
}
