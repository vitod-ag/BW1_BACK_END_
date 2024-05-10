package DAO;

import entities.Rivenditori.Rivenditore;
import entities.UtenteETessera.Tessera;
import entities.ViaggioTratta.Tratta;
import entities.ViaggioTratta.Viaggio;
import entities.mezzi.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

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

    public void saveAll(List<Tratta> tratte) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            for (Tratta tratta : tratte) {
                //  System.out.println(tratta);
                em.persist(tratta);
            }
            et.commit();
            System.out.println("Tratte salvati con successo");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante il salvataggio delle tratte: " + e.getMessage());
        }
    }

    public void tempoEffettivoTratta() {
        Query trattaQuery = em.createQuery("SELECT t FROM Tratta t");
       // trattaQuery.getResultList().forEach(System.out::println);
        setMediaEffettivaTrattaBYTratta(trattaQuery.getResultList());
    }

    public void setMediaEffettivaTrattaBYTratta(List<Tratta> tratta){
       // tratta.stream().map(Viaggio::getTempoEffettivo).mapToLong(time->((LocalTime) time).toSecondOfDay()).sum();
        tratta.stream().flatMap(t->t.getViaggi().stream()).mapToLong(v->v.getTempoEffettivo().toSecondOfDay())

    }


}
