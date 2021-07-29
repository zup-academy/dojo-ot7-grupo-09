package br.com.zup.edu.nossositedeviagens.Form;

import br.com.zup.edu.nossositedeviagens.Common.Validators.ExistsId;
import br.com.zup.edu.nossositedeviagens.Common.Validators.UniqueValue;
import br.com.zup.edu.nossositedeviagens.Model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.Model.Pais;
import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class AeroportoForm {

    @NotBlank @UniqueValue(fieldName = "nome", domainClass = Aeroporto.class)
    private String nome;

    @NotNull @ExistsId(fieldName = "id", domainClass = Pais.class)
    private Long idPais;

    public AeroportoForm(String nome, Long idPais){
        this.nome = nome;
        this.idPais = idPais;
    }

    public Aeroporto toModel(PaisRepository paisRepository){
        Optional<Pais> pais = paisRepository.findById(this.idPais);

        return new Aeroporto(this.nome, pais.get());
    }

}
