package br.com.zup.edu.nossositedeviagens.Form;

import br.com.zup.edu.nossositedeviagens.Common.Validators.ExistsId;
import br.com.zup.edu.nossositedeviagens.Common.Validators.UniqueValue;
import br.com.zup.edu.nossositedeviagens.Model.Companhia;
import br.com.zup.edu.nossositedeviagens.Model.Pais;
import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

public class CompanhiaForm {
    @NotBlank @UniqueValue(fieldName = "nome", domainClass = Companhia.class)
    private String nome;
    @NotNull @ExistsId(fieldName = "id",domainClass = Pais.class)
    private Long paisId;

    public Companhia toModel(PaisRepository paisRepository){
        Optional<Pais> pais = paisRepository.findById(paisId);
        return new Companhia(this.nome,pais.get());
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
