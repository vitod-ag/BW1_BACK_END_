package entities.TitoliViaggi;

import entities.Rivenditori.Rivenditore;
import entities.UtenteETessera.Utente;
import entities.mezzi.Mezzo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Biglietto extends TitoloDiViaggio {

private boolean validita;

private LocalDate timbratura;

    @ManyToOne
    @JoinColumn(name ="id_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private Mezzo mezzo;


      public Biglietto() {
        }

    public Biglietto(UUID idTitoloViaggio, Rivenditore rivenditore, LocalDate emissioneTitoloViaggio, boolean validita, LocalDate timbratura, Utente utente, Mezzo mezzo) {
        super(idTitoloViaggio, rivenditore, emissioneTitoloViaggio);
        this.validita = validita;
        this.timbratura = timbratura;
        this.utente = utente;
        this.mezzo = mezzo;
    }

    public boolean isValidita() {
        return validita;
    }

    public void setValidita(boolean validita) {
        this.validita = validita;
    }

    public LocalDate getTimbratura() {
        return timbratura;
    }

    public void setTimbratura(LocalDate timbratura) {
        this.timbratura = timbratura;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }
    @Override
    public String toString() {
        return super.toString() + "Biglietto{" +
                "validita=" + validita +
                ", timbratura=" + timbratura +
                ", utente=" + utente +
                ", mezzo=" + mezzo +
                '}';
    }
}
