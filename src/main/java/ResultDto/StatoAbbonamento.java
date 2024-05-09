package ResultDto;

import java.time.LocalDate;

public class StatoAbbonamento {
    private String nomeTessera;
    private LocalDate scadenzaAbbonamento;

    public StatoAbbonamento(String nomeTessera, LocalDate scadenzaAbbonamento) {
        this.nomeTessera = nomeTessera;
        this.scadenzaAbbonamento = scadenzaAbbonamento;
    }

    // Getters and setters
    public String getNomeTessera() {
        return nomeTessera;
    }

    public void setNomeTessera(String nomeTessera) {
        this.nomeTessera = nomeTessera;
    }

    public LocalDate getScadenzaAbbonamento() {
        return scadenzaAbbonamento;
    }

    public void setScadenzaAbbonamento(LocalDate scadenzaAbbonamento) {
        this.scadenzaAbbonamento = scadenzaAbbonamento;
    }
}
