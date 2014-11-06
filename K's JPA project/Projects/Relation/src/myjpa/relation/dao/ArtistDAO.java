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
import myjpa.relation.one2many.MyEntityManager;
import myjpa.relation.one2many.Song;

public class ArtistDAO {

    private EntityManagerFactory emf;

    public ArtistDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Artist find(int id) {

        try (MyEntityManager mem = new MyEntityManager(emf.createEntityManager())) {
            return mem.find(Artist.class, id);
        }
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//
//        }

    }

    public List<Artist> findAll() {
        return findAll(0, Integer.MAX_VALUE);
    }

    public List<Artist> findAll(int start, int size) {
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Artist> root = cq.from(Artist.class);

            //root.fetch("songs"); join fetch a.songs
            cq.select(root);

            Query query = em.createQuery(cq);
            query.setFirstResult(start);
            query.setMaxResults(size);

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    public int count() {
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Artist> root = cq.from(Artist.class);

            //root.fetch("songs"); join fetch a.songs
            cq.select(cb.count(root));

            Query query = em.createQuery(cq);

            return ((Long) query.getSingleResult()).intValue();

        } finally {
            em.close();
        }
    }

    public void create(Artist artist) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //Attach Object
            List<Song> attachSongs = new ArrayList<Song>();

            for (Song songAttach : artist.getSongs()) {
                if (songAttach.getId() != 0) {
                    songAttach = em.getReference(Song.class, songAttach.getId());
                }

                attachSongs.add(songAttach);
            }

            artist.setSongs(attachSongs);

            em.persist(artist);

            //Update Artist for each Song
            List<Song> songList = artist.getSongs();
            for (Song song : songList) {
                Artist oldArtist = song.getArtist();

                song.setArtist(artist);
                song = em.merge(song);

                if (oldArtist != null) {
                    oldArtist.getSongs().remove(song);
                    oldArtist = em.merge(oldArtist);
                }
            }

            em.getTransaction().commit();

        } catch (RuntimeException re) {
            em.getTransaction().rollback();

            throw re;
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Artist artist = em.getReference(Artist.class, id);
            em.remove(artist);
            em.getTransaction().commit();

        } catch (RuntimeException re) {
            em.getTransaction().rollback();

            throw re;
        } finally {
            em.close();
        }
    }

    public void edit(Artist artist) {

    }
}
