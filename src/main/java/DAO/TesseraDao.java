package DAO;

import entities.Rivenditori.Rivenditore;
import entities.UtenteETessera.Tessera;
import entities.UtenteETessera.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

    public void saveAll(List<Tessera> tessere) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            for (Tessera tessera : tessere) {
                //  System.out.println(tessere);
                em.persist(tessera);
            }
            et.commit();
            System.out.println("Tessere salvate con successo");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante il salvataggio delle tessere: " + e.getMessage());
        }
    }
}
