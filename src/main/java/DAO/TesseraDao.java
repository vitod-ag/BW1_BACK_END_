package DAO;

import entities.UtenteETessera.Tessera;
import entities.UtenteETessera.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesseraDao {
    private EntityManager em;

    public TesseraDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera) {
        try {
            em.getTransaction().begin();
            em.persist(tessera);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public Tessera getById(Integer id) {
        return em.find(Tessera.class, id);
    }

    public void delete(Tessera tessera) {
        try {
            em.getTransaction().begin();
            em.remove(tessera);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(Tessera tessera) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(tessera);
        et.commit();
    }
}
