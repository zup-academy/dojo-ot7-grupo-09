package br.com.zup.edu.nossositedeviagens.DTO;

import br.com.zup.edu.nossositedeviagens.Model.Rota;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VoosDtoResponse {

    private Long id;

    private LocalDateTime tempoParada;

    private int lugares;

    private List<Rota> rotas = new ArrayList<Rota>();

    public VoosDtoResponse(Long id, LocalDateTime tempoParada, int lugares, List<Rota> rotas) {
        this.id = id;
        this.tempoParada = tempoParada;
        this.lugares = lugares;
        this.rotas = rotas;
    }
}
