package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "titoli_viaggio")
public class TitoloDiViaggio {
    @Id
    @GeneratedValue
    @Column(name = "id_titolo_viaggio")
    private UUID idTitoloViaggio;


    @Column(name = "id_rivenditori")
    private int idRivenditori;

    private LocalDate emissioneTitoloViaggio;

    public TitoloDiViaggio(UUID idTitoloViaggio, int idRivenditori, LocalDate emissioneTitoloViaggio) {
        this.idTitoloViaggio = idTitoloViaggio;
        this.idRivenditori = idRivenditori;
        this.emissioneTitoloViaggio = emissioneTitoloViaggio;
    }

    public TitoloDiViaggio() {
    }

    public int getIdRivenditori() {
        return idRivenditori;
    }

    public void setIdRivenditori(int idRivenditori) {
        this.idRivenditori = idRivenditori;
    }

    public UUID getIdBiglietto() {
        return idTitoloViaggio;
    }

    public void setIdBiglietto(UUID idBiglietto) {
        this.idTitoloViaggio = idBiglietto;
    }

    public LocalDate getEmissioneTitoloViaggio() {
        return emissioneTitoloViaggio;
    }

    public void setEmissioneTitoloViaggio(LocalDate emissioneTitoloViaggio) {
        this.emissioneTitoloViaggio = emissioneTitoloViaggio;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "idBiglietto=" + idTitoloViaggio +
                ", idRivenditori=" + idRivenditori +
                ", emissioneTitoloViaggio=" + emissioneTitoloViaggio +
                '}';
    }
}
