package br.com.zup.edu.nossositedeviagens.DTO;

import br.com.zup.edu.nossositedeviagens.Model.Aeroporto;

public class AeroportoDtoResponse {

    private Long id;

    private String nome;

    private PaisDtoResponse pais;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisDtoResponse getPais() {
        return pais;
    }

    public AeroportoDtoResponse(Aeroporto aeroporto) {
        this.id = aeroporto.getId();
        this.nome = aeroporto.getNome();
        this.pais = new PaisDtoResponse(aeroporto.getPais());
    }
}
