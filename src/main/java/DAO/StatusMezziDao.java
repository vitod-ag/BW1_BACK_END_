package DAO;

import entities.StatusMezzo.StatusMezzo;
import entities.UtenteETessera.Tessera;
import entities.mezzi.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

       /* public List<Mezzo> getStatus(String targa) {
            LocalDate dataOggi = LocalDate.now();


            Query query = em.createQuery("SELECT a.scadenza FROM Abbonamento a WHERE a.tessera.idTessera = :idNumeroTessera");
            query.setParameter("idNumeroTessera", targa);

            LocalDate scadenzaAbbonamento = (LocalDate) query.getSingleResult();
            if (dataOggi.isAfter(scadenzaAbbonamento)) {
                System.out.println("Abbonamento scaduto in data: "+scadenzaAbbonamento);
            } else {
                System.out.println("Abbonamento valido fino al: " + scadenzaAbbonamento);
            }
        }*/

    }
}