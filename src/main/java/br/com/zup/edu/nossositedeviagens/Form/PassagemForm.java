package br.com.zup.edu.nossositedeviagens.Form;

import br.com.zup.edu.nossositedeviagens.Model.Passagem;
import br.com.zup.edu.nossositedeviagens.Model.Voos;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PassagemForm {

    @NotNull
    private Long idVoo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDateTime horaPartida;

    @Positive
    @NotNull
    private BigDecimal valor;

    public Long getIdVoo() {
        return idVoo;
    }

    public LocalDateTime getHoraPartida() {
        return horaPartida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Passagem formToModel() {
        return new Passagem(
                new Voos(idVoo),
                horaPartida,
                valor
        );
    }
}
