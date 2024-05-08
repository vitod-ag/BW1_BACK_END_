package DAO;

import entities.StatusMezzo.StatusMezzo;
import entities.UtenteETessera.Tessera;
import entities.mezzi.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

    public void saveAll(List<StatusMezzo> statusMezzi) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            for (StatusMezzo stusMezzo : statusMezzi) {
               // System.out.println(stusMezzo);
                em.persist(stusMezzo);
            }
            et.commit();
            System.out.println("Prestiti salvati con successo");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante il salvataggio dei statusMezzi: " + e.getMessage());
        }
    }
}