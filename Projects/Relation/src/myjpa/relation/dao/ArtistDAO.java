/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjpa.relation.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import myjpa.relation.one2many.Artist;
import myjpa.relation.one2many.Song;

/**
 *
 * @author com
 */
public class ArtistDAO<T> {

    private EntityManagerFactory emf;
    private Class<T> eClass;

    public ArtistDAO(EntityManagerFactory emf, Class<T> eClass) {
        this.emf = emf;
        this.eClass = eClass;
    }

    public T find(int id) {
        // Use try with resource (java7) to let em close itself without finally block
        try (MyEntityManager em = new MyEntityManager(emf.createEntityManager())) {
            return em.find(eClass, id);
        }
    }

    public List<T> findAll() {
        return findAll(0, Integer.MAX_VALUE);
    }

    public List<T> findAll(int start, int size) {
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Artist> root = cq.from(eClass);

            root.fetch("songs");
            cq.distinct(true).select(root); //.where( ).orderBy( );

            Query query = em.createQuery(cq);
            query.setFirstResult(start);
            query.setMaxResults(size);

            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public int count() {
        try (MyEntityManager em = new MyEntityManager(emf.createEntityManager())) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Artist> root = cq.from(eClass);

            cq.select(cb.count(root));

            Query query = em.createQuery(cq);

            return ((Long) query.getSingleResult()).intValue();
        }
    }

    public void create(Artist artist) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            checkExistingSongs(artist, em);

            em.persist(artist);

            updateArtistOfSong(artist, em);

            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    /**
     * Check does the attached song exist or not.
     * If id is not null, use getReference to get it from JPA world.
     * 
     * @param artist
     * @param em
     */
    private void checkExistingSongs(Artist artist, EntityManager em) {
        List<Song> attachSongs = new ArrayList<>();

        for (Song songAttach : artist.getSongs()) {
            if (songAttach.getId() != null) {
                songAttach = em.getReference(Song.class, songAttach.getId());
            }
            attachSongs.add(songAttach);
        }
        artist.setSongs(attachSongs);
    }

    private void updateArtistOfSong(Artist artist, EntityManager em) {
        List<Song> songs = artist.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            Artist oldArtist = song.getArtist();

            song.setArtist(artist);
            song = em.merge(song); // Do we need to merge here?

            if (oldArtist != null) {
                oldArtist.getSongs().remove(song);
                oldArtist = em.merge(oldArtist); // Do we need to merge here?
            }
        }
    }

    public void destroy(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Artist artist = em.getReference(Artist.class, id);
            em.remove(artist);

            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public void edit(Artist artist) {

    }
}
