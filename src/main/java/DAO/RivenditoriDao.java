package DAO;

import entities.Rivenditori.Rivenditore;
import entities.UtenteETessera.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RivenditoriDao {
    private EntityManager em;

    public RivenditoriDao(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore rivenditore) {
        try {
            em.getTransaction().begin();
            em.persist(rivenditore);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public Rivenditore getById(Integer id) {
        return em.find(Rivenditore.class, id);
    }

    public void delete(Rivenditore rivenditore) {
        try {
            em.getTransaction().begin();
            em.remove(rivenditore);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(Rivenditore rivenditore) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(rivenditore);
        et.commit();
    }
}
