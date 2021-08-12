package br.com.zup.edu.nossositedeviagens.DTO;

public class RotaDtoResponse {

    private Long id;

    private String nome;

    private AeroportoDtoResponse aeroportoDtoResponseOrigem;

    private AeroportoDtoResponse aeroportoDtoResponseDestino;

    private Integer duracao;

    public RotaDtoResponse(Long id, String nome, AeroportoDtoResponse aeroportoDtoResponseOrigem, AeroportoDtoResponse aeroportoDtoResponseDestino, Integer duracao) {
        this.id = id;
        this.nome = nome;
        this.aeroportoDtoResponseOrigem = aeroportoDtoResponseOrigem;
        this.aeroportoDtoResponseDestino = aeroportoDtoResponseDestino;
        this.duracao = duracao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public AeroportoDtoResponse getAeroportoResponseOrigem() {
        return aeroportoDtoResponseOrigem;
    }

    public AeroportoDtoResponse getAeroportoResponseDestino() {
        return aeroportoDtoResponseDestino;
    }
}
