package DAO;

import entities.TitoliViaggi.TitoloDiViaggio;
import entities.UtenteETessera.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TitoloDiViaggioDao {
    private EntityManager em;

    public TitoloDiViaggioDao(EntityManager em) {
        this.em = em;
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {
        try {
            em.getTransaction().begin();
            em.persist(titoloDiViaggio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public TitoloDiViaggio getById(Integer id) {
        return em.find(TitoloDiViaggio.class, id);
    }

    public void delete(TitoloDiViaggio titoloDiViaggio) {
        try {
            em.getTransaction().begin();
            em.remove(titoloDiViaggio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(TitoloDiViaggio titoloDiViaggio) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(titoloDiViaggio);
        et.commit();
    }
}
