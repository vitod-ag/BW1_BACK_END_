package DAO;

import entities.StatusMezzo.StatusMezzo;
import entities.UtenteETessera.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StatusMezziDao {
    private EntityManager em;

    public StatusMezziDao(EntityManager em) {
        this.em = em;
    }

    public void save(StatusMezzo statusMezzi) {
        try {
            em.getTransaction().begin();
            em.persist(statusMezzi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public StatusMezzo getById(Integer id) {
        return em.find(StatusMezzo.class, id);
    }

    public void delete(StatusMezzo statusMezzi) {
        try {
            em.getTransaction().begin();
            em.remove(statusMezzi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(StatusMezzo statusMezzi) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(statusMezzi);
        et.commit();
    }
}
