package DAO;

import entities.UtenteETessera.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        try {
            em.getTransaction().begin();
            em.persist(utente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public Utente getById(Integer id) {
        return em.find(Utente.class, id);
    }

    public void delete(Utente utente) {
        try {
            em.getTransaction().begin();
            em.remove(utente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(utente);
        et.commit();
    }
}
