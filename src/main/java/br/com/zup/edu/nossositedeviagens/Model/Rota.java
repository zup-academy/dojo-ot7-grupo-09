package br.com.zup.edu.nossositedeviagens.Model;

import br.com.zup.edu.nossositedeviagens.DTO.AeroportoResponseDTO;
import br.com.zup.edu.nossositedeviagens.DTO.RotaResponse;

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

    public Rota() {
    }

    public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, Integer duracao) {
        this.nome = nome;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracao = duracao;
    }

    public RotaResponse domainToResponse() {
        return new RotaResponse(this.id, this.nome,
                new AeroportoResponseDTO(this.aeroportoOrigem),
                new AeroportoResponseDTO(this.aeroportoDestino));
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
