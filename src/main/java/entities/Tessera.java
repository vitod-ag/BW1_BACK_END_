package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tessere")

public class Tessera {
    @Id
    @GeneratedValue
    @Column(name = "id_tessera")
    private UUID idTessera;
    @OneToOne(mappedBy = "tessera")
    private Abbonamento abbonamento;


    private LocalDate emissione;

    private LocalDate scadenza;


    @OneToOne
    @JoinColumn(name = "id_utente")//fk
    // collegamento con utente con prioritario utente
    private Utente utente;

    public Tessera(UUID idTessera, LocalDate emissione, LocalDate scadenza, Utente utente) {
        this.idTessera = idTessera;
        this.emissione = emissione;
        this.scadenza = emissione.plusYears(1);
        this.utente = utente;
    }
}
