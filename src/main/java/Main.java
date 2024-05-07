import DAO.UtenteDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    //private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw1");
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw1");
        EntityManager em = emf.createEntityManager();
        UtenteDao utenteDao = new UtenteDao(em);





    }
}
