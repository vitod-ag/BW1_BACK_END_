import DAO.*;
import ResultDto.CountRivenditoriViaggi;
import entities.Rivenditori.DistributoreAutomatico;
import entities.Rivenditori.Rivenditore;
import entities.Rivenditori.RivenditoreAutorizzato;
import entities.StatusMezzo.StatusMezzo;
import entities.TitoliViaggi.Abbonamento;
import entities.TitoliViaggi.Biglietto;
import entities.UtenteETessera.Tessera;
import entities.UtenteETessera.Utente;
import entities.ViaggioTratta.Tratta;
import entities.ViaggioTratta.Viaggio;
import entities.mezzi.Autobus;
import entities.mezzi.Mezzo;
import entities.mezzi.Tram;
import enums.EmissioneAbbonamento;
import enums.EnumStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    private static Viaggio viaggio2;

    //private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw1");
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw1");
        EntityManager em = emf.createEntityManager();

        UtenteDao utenteDao = new UtenteDao(em);
        TesseraDao tesseraDao = new TesseraDao(em);
        RivenditoriDao rivenditoriDao = new RivenditoriDao(em);
        TitoloDiViaggioDao titoloDiViaggioDao = new TitoloDiViaggioDao(em);
        TrattaDao trattaDao = new TrattaDao(em);
        ViaggioDao viaggioDao = new ViaggioDao(em);
        MezziDao mezzoDao = new MezziDao(em);
        StatusMezziDao statusMezzoDao = new StatusMezziDao(em);


        //UTENTE 1---------------- CON TESSERA------------
        //Tessera
        Tessera t1 = new Tessera();
        t1.setEmissione(LocalDate.of(2022, 10, 10));
        tesseraDao.save(t1);

        //utente
        Utente u1 = new Utente();
        u1.setNome("Mario");
        u1.setCognome("Rossi");
        u1.setDataNascita(LocalDate.of(1990, 10, 10));
        t1.setUtente(u1);
        utenteDao.save(u1);

        //UTENTE 2---------------- CON TESSERA------------

        Tessera t2 = new Tessera();
        t2.setEmissione(LocalDate.of(2023, 5, 12));
        tesseraDao.save(t2);
        Utente u2 = new Utente();
        u2.setNome("Roberta");
        u2.setCognome("Verdi");
        u2.setDataNascita(LocalDate.of(2006, 1, 10));
        t2.setUtente(u2);
        utenteDao.save(u2);

        //UTENTE 3---------------- CON TESSERA----------------

        Tessera t3 = new Tessera();
        t3.setEmissione(LocalDate.of(2023, 10, 12));

        tesseraDao.save(t3);

        Utente u3 = new Utente();
        u3.setNome("Roberta");
        u3.setCognome("Verdi");
        u3.setDataNascita(LocalDate.of(1996, 1, 10));
        t3.setUtente(u3);
        utenteDao.save(u3);


        //UTENTE4------SENZA TESSERA---------------------------------------------------------
        Utente u4 = new Utente();
        u4.setNome("Ajeje");
        u4.setCognome("Brazzorf");
        u4.setDataNascita(LocalDate.of(2003, 1, 11));

        utenteDao.save(u4);

        // distributori, rivenditori autorizzati,


        DistributoreAutomatico distributoreAutomatico1 = new DistributoreAutomatico();
        DistributoreAutomatico distributoreAutomatico2 = new DistributoreAutomatico();
        DistributoreAutomatico distributoreAutomatico3 = new DistributoreAutomatico();

        distributoreAutomatico1.setStatoServizio(true);
        distributoreAutomatico1.setNomeDistributore("DA1");
        distributoreAutomatico2.setStatoServizio(false);
        distributoreAutomatico2.setNomeDistributore("DA2");
        distributoreAutomatico3.setStatoServizio(true);
        distributoreAutomatico3.setNomeDistributore("DA3");

        rivenditoriDao.save(distributoreAutomatico1);
        rivenditoriDao.save(distributoreAutomatico2);
        rivenditoriDao.save(distributoreAutomatico3);


        RivenditoreAutorizzato rivenditoreAutorizzato1 = new RivenditoreAutorizzato();
        RivenditoreAutorizzato rivenditoreAutorizzato2 = new RivenditoreAutorizzato();
        RivenditoreAutorizzato rivenditoreAutorizzato3 = new RivenditoreAutorizzato();

        rivenditoreAutorizzato1.setNomeRivenditore("Baracchino 1");
        rivenditoreAutorizzato1.setIndirizzo("Via Giuseppe Meazza");

        rivenditoreAutorizzato2.setNomeRivenditore("Giornalaio");
        rivenditoreAutorizzato2.setIndirizzo("Piazza di Spagna");

        rivenditoreAutorizzato3.setNomeRivenditore("Baracchino 2");
        rivenditoreAutorizzato3.setIndirizzo("Via dei Baracchini 50");

        rivenditoriDao.save(rivenditoreAutorizzato1);
        rivenditoriDao.save(rivenditoreAutorizzato2);
        rivenditoriDao.save(rivenditoreAutorizzato3);


        // parte biglietto, abbonamento

        Biglietto biglietto1 = new Biglietto();

        biglietto1.setRivenditore(rivenditoreAutorizzato1);
        biglietto1.setUtente(u4);
        biglietto1.setEmissioneTitoloViaggio(LocalDate.of(2024, 5, 8));


        Biglietto biglietto2 = new Biglietto();

        biglietto2.setRivenditore(rivenditoreAutorizzato2);
        biglietto1.setUtente(u3);
        biglietto1.setEmissioneTitoloViaggio(LocalDate.of(2024, 5, 7));


        Abbonamento abbonamento1 = new Abbonamento();
        abbonamento1.setRivenditore(rivenditoreAutorizzato2);
        abbonamento1.setTessera(t2);
        abbonamento1.setEmissione(EmissioneAbbonamento.MENSILE);
        abbonamento1.setEmissioneTitoloViaggio(LocalDate.of(2024, 5, 8));

        Abbonamento abbonamento2 = new Abbonamento();
        abbonamento2.setRivenditore(rivenditoreAutorizzato3);
        abbonamento2.setTessera(t3);
        abbonamento2.setEmissione(EmissioneAbbonamento.SETTIMANALE);
        abbonamento2.setEmissioneTitoloViaggio(LocalDate.of(2024, 5, 8));

        titoloDiViaggioDao.save(abbonamento1);
        titoloDiViaggioDao.save(abbonamento2);

        // parte mezzi, status, tratta

        Autobus autobus1 = new Autobus();
        autobus1.setTarga("BY230JA");

        Tram tram1 = new Tram();
        tram1.setTarga("CG540KA");

        Autobus autobus2 = new Autobus();
        autobus2.setTarga("AY230JA");

        Tram tram2 = new Tram();
        tram2.setTarga("ZG540KA");

        Autobus autobus3 = new Autobus();
        autobus3.setTarga("KY230JA");

        Tram tram3 = new Tram();
        tram3.setTarga("XG540KA");

        Autobus autobus4 = new Autobus();
        autobus4.setTarga("LY230JA");

        Tram tram4 = new Tram();
        tram4.setTarga("VG540KA");


        Autobus autobus5 = new Autobus();
        autobus5.setTarga("QY230JA");

        Tram tram5 = new Tram();
        tram5.setTarga("MG540KA");

        mezzoDao.save(autobus1);
        mezzoDao.save(autobus2);
        mezzoDao.save(autobus3);
        mezzoDao.save(autobus4);
        mezzoDao.save(autobus5);

        mezzoDao.save(tram1);
        mezzoDao.save(tram2);
        mezzoDao.save(tram3);
        mezzoDao.save(tram4);
        mezzoDao.save(tram5);
        mezzoDao.saveAll(List.of(autobus1, autobus2, autobus3, autobus4, autobus5, tram1, tram2, tram3, tram4, tram5));

        //Utilizzo biglietti
        biglietto1.setMezzo(autobus1);
        biglietto1.setstatusValidita(true);
        biglietto1.setTimbratura(LocalDate.of(2024, 5, 8));

        biglietto2.setMezzo(autobus1);
        biglietto2.setstatusValidita(true);
        biglietto2.setTimbratura(LocalDate.of(2024, 5, 7));
        titoloDiViaggioDao.save(biglietto1);
        titoloDiViaggioDao.save(biglietto2);
        //viaggi, tratte
        Tratta tratta1 = new Tratta();
        tratta1.setNomePartenza("Piazza Maggiore");
        tratta1.setNomeArrivo(("Stadio San Siro"));
        Tratta tratta2 = new Tratta();
        tratta1.setNomePartenza("Via Bella");
        tratta1.setNomeArrivo(("Piazza Grande"));

        StatusMezzo statusMezzo1 = new StatusMezzo();
        statusMezzo1.setMezzo(autobus1);
        statusMezzo1.setStatus(EnumStatus.IN_SERVIZIO);
        statusMezzo1.setDataInizio(LocalDate.of(2024, 1, 10));

        StatusMezzo statusMezzo2 = new StatusMezzo();
        statusMezzo2.setMezzo(autobus1);
        statusMezzo2.setStatus(EnumStatus.IN_MANUTENZIONE);
        statusMezzo2.setDataInizio(LocalDate.of(2023, 12, 10));
        statusMezzo2.setDataFine(LocalDate.of(2024, 1, 10));





        Viaggio viaggio1 = new Viaggio();
        viaggio1.setTempoEffettivo(LocalTime.of(0, 30));
        viaggio1.setNomeTratta("Viaggio");
        Viaggio viaggio2 = new Viaggio();
        viaggio2.setTempoEffettivo(LocalTime.of(0, 30));
        viaggio2.setNomeTratta("05/");
        viaggio2.setMezzi(List.of(autobus1));
        trattaDao.saveAll(List.of(tratta1, tratta2));
        statusMezzoDao.save(statusMezzo1);
        statusMezzoDao.save(statusMezzo2);
        trattaDao.save(tratta2);
        trattaDao.save(tratta1);
        viaggio1.setTratta(tratta1);
        viaggio2.setTratta(tratta2);
        viaggioDao.save(viaggio1);
        viaggioDao.save(viaggio2);

        Biglietto biglietto7 = new Biglietto();
        biglietto7.setUtente(u1);
        biglietto7.setRivenditore(distributoreAutomatico1);
        biglietto7.setEmissioneTitoloViaggio(LocalDate.of(2024, 10, 5));
        titoloDiViaggioDao.save(biglietto7);

        Biglietto biglietto8 = new Biglietto();
        biglietto8.setUtente(u3);
        biglietto8.setRivenditore(rivenditoreAutorizzato1);
        biglietto8.setEmissioneTitoloViaggio(LocalDate.of(2024, 2, 10));
        titoloDiViaggioDao.save(biglietto8);

//        ---QUERY----
//        Deve essere possibile tenere traccia del numero di biglietti e/o abbonamenti emessi
//        in un dato periodo di tempo in totale e per punto di emissione
        System.out.println("QUERY.1");
        List<CountRivenditoriViaggi> results = titoloDiViaggioDao.getTotaleBiglietti(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31));

        results.forEach(result -> {
            if (result.getRivenditore() instanceof RivenditoreAutorizzato) {
                RivenditoreAutorizzato autorizzato = (RivenditoreAutorizzato) result.getRivenditore();
                System.out.println(autorizzato.getNomeRivenditore() + " " + result.getNumTitoli());
            } else if (result.getRivenditore() instanceof DistributoreAutomatico) {
                DistributoreAutomatico distributore = (DistributoreAutomatico) result.getRivenditore();
                System.out.println(distributore.getNomeDistributore() + " " + result.getNumTitoli());
            } else {
                System.out.println("Nessun risultato trovato");
            }
        });

//         ---QUERY 2----
//        Deve essere possibile tenere traccia della scadenza degli abbonamenti dato il numero della tessera di un utente

        System.out.println();
        System.out.println("QUERY.2");


        titoloDiViaggioDao.getStatoAbbonamento3("cabdea43-4e66-441e-8074-a2d18200e90b");

        System.out.println();
        System.out.println("QUERY.3");

        // ---QUERY 3----
//        Deve essere possibile tenere traccia della scadenza degli abbonamenti dato il numero della tessera di un utente
       tesseraDao.getValiditaTessera("61916754-b5b9-4df8-b888-39d2d8fa0ec3");


        System.out.println();
        System.out.println("Query.4");
        //--query 4 StatusMezzi --
        statusMezzoDao.getStatusMezzi(EnumStatus.IN_MANUTENZIONE);
        System.out.println();
        System.out.println("Query.5");
        //--query 5 statusMezzo
        statusMezzoDao.getStatusMezzo("3aca5c81-2d1c-48b7-8216-ed86ef1ff0a7",EnumStatus.IN_MANUTENZIONE);


    }
}
