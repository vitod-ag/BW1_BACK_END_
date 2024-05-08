package DAO;

import entities.UtenteETessera.Tessera;
import entities.mezzi.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MezziDao {
    private EntityManager em;

    public MezziDao(EntityManager em) {
        this.em = em;
    }

    public void save(Mezzo mezzi) {
        try {
            em.getTransaction().begin();
            em.persist(mezzi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public Mezzo getById(Integer id) {
        return em.find(Mezzo.class, id);
    }

    public void delete(Mezzo mezzi) {
        try {
            em.getTransaction().begin();
            em.remove(mezzi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(Mezzo mezzi) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(mezzi);
        et.commit();
    }
}
