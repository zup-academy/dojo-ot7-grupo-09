package br.com.zup.edu.nossositedeviagens.Form;

import br.com.zup.edu.nossositedeviagens.Common.TipoRota;
import br.com.zup.edu.nossositedeviagens.Common.Validators.ExistsId;
import br.com.zup.edu.nossositedeviagens.Model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.Model.Rota;
import br.com.zup.edu.nossositedeviagens.Repository.AeroportoRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

public class RotaForm {

    private String nome;

    @NotNull @ExistsId(domainClass = Aeroporto.class, fieldName = "id")
    private Long idAeroportoOrigem;

    @NotNull @ExistsId(domainClass = Aeroporto.class, fieldName = "id")
    private Long idAeroportoDestino;

    @Positive
    @NotNull
    private Integer duracao;

    @Enumerated(EnumType.STRING)
    private TipoRota tipoRota;

    public RotaForm(String nome, Long idAeroportoOrigem, Long idAeroportoDestino, Integer duracao, TipoRota tipoRota) {
        this.nome = nome;
        this.idAeroportoOrigem = idAeroportoOrigem;
        this.idAeroportoDestino = idAeroportoDestino;
        this.duracao = duracao;
        this.tipoRota = tipoRota;
    }

    public Rota formToModel(AeroportoRepository aeroportoRepository) {
        Optional<Aeroporto> aeroportoOrigem = aeroportoRepository.findById(this.idAeroportoOrigem);
        Optional<Aeroporto> aeroportoDestino = aeroportoRepository.findById(this.idAeroportoOrigem);

        if (this.nome == null || this.nome.isBlank()) {
            return new Rota(aeroportoOrigem.get().getNome() + aeroportoDestino.get().getNome(),
                    aeroportoOrigem.get(), aeroportoDestino.get(), duracao, tipoRota);
        }

        return new Rota(this.nome, aeroportoOrigem.get(), aeroportoDestino.get(), duracao, tipoRota);

    }

}
