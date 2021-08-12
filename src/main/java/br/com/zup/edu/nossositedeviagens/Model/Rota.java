package br.com.zup.edu.nossositedeviagens.Model;

import br.com.zup.edu.nossositedeviagens.Common.TipoRota;
import br.com.zup.edu.nossositedeviagens.DTO.AeroportoDtoResponse;
import br.com.zup.edu.nossositedeviagens.DTO.RotaDtoResponse;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Aeroporto aeroportoOrigem;

    @ManyToOne
    private Aeroporto aeroportoDestino;

    @Positive
    @NotNull
    private Integer duracao;

    @ManyToOne
    private Voos voos;

    @Enumerated(EnumType.STRING)
    private TipoRota tipoRota;

    @Deprecated
    public Rota() {
    }

    public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, Integer duracao, TipoRota tipoRota) {
        this.nome = nome;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracao = duracao;
        this.tipoRota = tipoRota;
    }

    public RotaDtoResponse domainToResponse() {
        return new RotaDtoResponse(this.id, this.nome,
                new AeroportoDtoResponse(this.aeroportoOrigem),
                new AeroportoDtoResponse(this.aeroportoDestino),
                this.duracao);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Aeroporto getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public Aeroporto getAeroportoDestino() {
        return aeroportoDestino;
    }

    public Integer getDuracao() {
        return duracao;
    }
}
