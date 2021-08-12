package br.com.zup.edu.nossositedeviagens.Form;

import br.com.zup.edu.nossositedeviagens.Model.Rota;
import br.com.zup.edu.nossositedeviagens.Model.Voos;

import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VoosForm {

    @Positive
    private LocalDateTime tempoParada = LocalDateTime.now();
    @NotNull
    @Positive
    private int lugares;
    @NotNull
    @Min(1)
    private List<Rota> rotas = new ArrayList<Rota>();

    public VoosForm(int lugares, List<Rota> rotas) {
        this.lugares = lugares;
        this.rotas = rotas;
    }

    public LocalDateTime getTempoParada() {
        return tempoParada;
    }

    public int getLugares() {
        return lugares;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public Voos toModel() {
        Voos voos = new Voos(lugares, rotas);
        if (tempoParada != null) {
            voos.setTempoParada(tempoParada);
        }
        return voos;
    }
}
