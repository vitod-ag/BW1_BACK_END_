package DAO;

import entities.UtenteETessera.Tessera;
import entities.ViaggioTratta.Viaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ViaggioDao {
    private EntityManager em;

    public ViaggioDao(EntityManager em) {
        this.em = em;
    }

    public void save(Viaggio viaggio) {
        try {
            em.getTransaction().begin();
            em.persist(viaggio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public Viaggio getById(Integer id) {
        return em.find(Viaggio.class, id);
    }

    public void delete(Viaggio viaggio) {
        try {
            em.getTransaction().begin();
            em.remove(viaggio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(Viaggio viaggio) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(viaggio);
        et.commit();
    }
}
