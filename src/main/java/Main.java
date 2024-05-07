import DAO.TesseraDao;
import DAO.UtenteDao;
import entities.UtenteETessera.Tessera;
import entities.UtenteETessera.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    //private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw1");
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw1");
        EntityManager em = emf.createEntityManager();
        UtenteDao utenteDao = new UtenteDao(em);
        TesseraDao tesseraDao = new TesseraDao(em);
        //Tessera
        Tessera t1 = new Tessera();
        t1.setEmissione(LocalDate.of(2022, 10, 10));
        tesseraDao.save(t1);

        //utente
        Utente u1= new Utente();
        u1.setNome("Mario");
        u1.setCognome("Rossi");
        u1.setDataNascita(LocalDate.of(1990, 10, 10));
        t1.setUtente(u1);

        utenteDao.save(u1);



    }
}
