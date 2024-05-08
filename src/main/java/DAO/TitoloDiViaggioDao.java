package DAO;

import ResultDto.CountRivenditoriViaggi;
import entities.Rivenditori.Rivenditore;
import entities.TitoliViaggi.TitoloDiViaggio;
import entities.UtenteETessera.Utente;
import entities.mezzi.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

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

    public void saveAll(List<TitoloDiViaggio> titolodiviaggi) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            for (TitoloDiViaggio titolidiviaggio : titolodiviaggi) {
                //  System.out.println(titolidiviaggio);
                em.persist(titolidiviaggio);
            }
            et.commit();
            System.out.println("Prestiti salvati con successo");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante il salvataggio dei mezzi: " + e.getMessage());
        }
    }

    //parte delle query

//     -Deve essere possibile tenere traccia del numero di biglietti e/o abbonamenti emessi
//    in un dato periodo di tempo in totale e per punto di emissione




 public List<CountRivenditoriViaggi> getTotaleBiglietti(LocalDate inizio, LocalDate fine) {
     Query query = em.createQuery("SELECT new ResultDto.CountRivenditoriViaggi(t.rivenditore, COUNT(t) AS numTitoli) " +
             "FROM TitoloDiViaggio t " +
             "WHERE t.emissioneTitoloViaggio BETWEEN :startDate AND :endDate " +
             "GROUP BY t.rivenditore"
     );
       query.setParameter("startDate", inizio);
       query.setParameter("endDate", fine);
       return query.getResultList();
   }


//    select r.idrivenditore, count(t.*) as numTitoli from public.titoli_viaggio t
//    inner join public.rivenditori r
//    on t.id_rivenditori = r.idrivenditore where t.emissionetitoloviaggio
//    between '2024-01-01' and '2024-12-31' group by r.idrivenditore;


}
