package entities;

import enums.EmissioneAbbonamento;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Abbonamento extends  TitoloDiViaggio{

    private EmissioneAbbonamento emissione;



    @OneToOne
    @JoinColumn(name = "id_tessera")
    private Tessera tessera;

    public Abbonamento(UUID idTitoloViaggio, int idRivenditori, LocalDate emissioneTitoloViaggio, EmissioneAbbonamento emissione, Tessera tessera) {
        super(idTitoloViaggio, idRivenditori, emissioneTitoloViaggio);
        this.emissione = emissione;
        this.tessera = tessera;
    }

    public Abbonamento() {
    }

    public EmissioneAbbonamento getEmissione() {
        return emissione;
    }

    public void setEmissione(EmissioneAbbonamento emissione) {
        this.emissione = emissione;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "emissione=" + emissione +
                ", tessera=" + tessera +
                "} " + super.toString();
    }
}
