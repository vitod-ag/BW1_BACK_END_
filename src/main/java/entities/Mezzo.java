package entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mezzi")
public class Mezzo {
    @Id
    @GeneratedValue
    @Column(name = "id_mezzo")
    private UUID idMezzi;

   @OneToMany(mappedBy = "mezzo")
    private List<Biglietto> biglietto;



}
