package br.com.zup.edu.nossositedeviagens.DTO;

import br.com.zup.edu.nossositedeviagens.Model.Pais;

public class PaisDtoResponse {
    private String nome;

    public PaisDtoResponse(Pais pais) {
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }
}
