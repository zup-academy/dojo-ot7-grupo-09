package br.com.zup.edu.nossositedeviagens.Model;

import br.com.zup.edu.nossositedeviagens.DTO.PassagemDtoResponse;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Voos voo;

    @Future
    private LocalDateTime horaPartida;

    @Positive
    @NotNull
    private BigDecimal valor;

    public Passagem() {
    }

    public Passagem(Voos voo, LocalDateTime horaPartida, BigDecimal valor) {
        this.voo = voo;
        this.horaPartida = horaPartida;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public PassagemDtoResponse domainToResponse() {
        return new PassagemDtoResponse(
                voo.domainToResponse(),
                horaPartida,
                valor
        );
    }

}
