package br.com.zup.edu.nossositedeviagens.DTO;

public class RotaResponse {

    private Long id;

    private String nome;

    private AeroportoResponseDTO aeroportoResponseOrigem;

    private AeroportoResponseDTO aeroportoResponseDestino;

    private Integer duracao;

    public RotaResponse(Long id, String nome, AeroportoResponseDTO aeroportoResponseOrigem, AeroportoResponseDTO aeroportoResponseDestino, Integer duracao) {
        this.id = id;
        this.nome = nome;
        this.aeroportoResponseOrigem = aeroportoResponseOrigem;
        this.aeroportoResponseDestino = aeroportoResponseDestino;
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

    public AeroportoResponseDTO getAeroportoResponseOrigem() {
        return aeroportoResponseOrigem;
    }

    public AeroportoResponseDTO getAeroportoResponseDestino() {
        return aeroportoResponseDestino;
    }
}
