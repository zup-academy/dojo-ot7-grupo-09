package br.com.zup.edu.nossositedeviagens.Form;

import br.com.zup.edu.nossositedeviagens.Model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank
    private String nome;

    public Pais toModel(){
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
