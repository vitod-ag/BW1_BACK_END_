package DAO;

import entities.UtenteETessera.Tessera;
import entities.ViaggioTratta.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TrattaDao {
    private EntityManager em;

    public TrattaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        try {
            em.getTransaction().begin();
            em.persist(tratta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public Tratta getById(Integer id) {
        return em.find(Tratta.class, id);
    }

    public void delete(Tratta tratta) {
        try {
            em.getTransaction().begin();
            em.remove(tratta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(Tratta tratta) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(tratta);
        et.commit();
    }
}
