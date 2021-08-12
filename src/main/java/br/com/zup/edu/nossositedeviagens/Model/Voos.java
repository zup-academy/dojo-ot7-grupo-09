package br.com.zup.edu.nossositedeviagens.Model;

import br.com.zup.edu.nossositedeviagens.DTO.VoosDtoResponse;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Voos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    private LocalDateTime tempoParada = LocalDateTime.now();
    @NotNull
    @Positive
    private int lugares;
    @NotNull
    @Size(min=1)
    @OneToMany(mappedBy = "voos")
    private List<Rota> rotas = new ArrayList<Rota>();

    public Voos(@NotNull @Positive int lugares, @NotNull List<Rota> rotas) {
        this.tempoParada = tempoParada;
        this.lugares = lugares;
        this.rotas = rotas;
    }

    public Long getId() {
        return id;
    }

    public void setTempoParada(LocalDateTime tempoParada) {
        this.tempoParada = tempoParada;
    }

    public VoosDtoResponse domainToResponse() {
        return new VoosDtoResponse(
                id,
                tempoParada,
                lugares,
                rotas
        );
    }

    public Voos(Long id) {
        this.id = id;
    }
}
