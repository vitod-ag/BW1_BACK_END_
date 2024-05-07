package DAO;

import entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getById(Integer id) {
        return em.find(Utente.class, id);
    }

    public void delete(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(utente);
        et.commit();
    }

//    public void update(Catalogo catalogo) {
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        em.merge(catalogo);
//        et.commit();
//    }
}
