package br.com.zup.edu.nossositedeviagens.DTO;

import br.com.zup.edu.nossositedeviagens.Model.Companhia;
import br.com.zup.edu.nossositedeviagens.Model.Pais;

public class CompanhiaDtoResponse {
    private Long id;
    private String nome;
    private PaisDtoResponse pais;

    public CompanhiaDtoResponse(Companhia companhia) {
        this.id = companhia.getId();
        this.nome = companhia.getNome();
        this.pais = new PaisDtoResponse(companhia.getPais());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisDtoResponse getPais() {
        return pais;
    }
}
