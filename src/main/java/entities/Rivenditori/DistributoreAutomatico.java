package entities.Rivenditori;

import entities.TitoliViaggi.TitoloDiViaggio;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "distributori_automatici")
public class DistributoreAutomatico extends Rivenditore {
    private boolean statoServizio;

    public DistributoreAutomatico(int idRivenditore, List<TitoloDiViaggio> titoliDiViaggio, boolean statoServizio) {
        super(idRivenditore, titoliDiViaggio);
        this.statoServizio = statoServizio;
    }
    public DistributoreAutomatico() {    }

    public boolean isStatoServizio() {
        return statoServizio;
    }

    public void setStatoServizio(boolean statoServizio) {
        this.statoServizio = statoServizio;
    }
    @Override
    public String toString() {
        return super.toString()+"DistributoreAutomatico{" +
                "statoServizio=" + statoServizio +
                '}';
    }
}
