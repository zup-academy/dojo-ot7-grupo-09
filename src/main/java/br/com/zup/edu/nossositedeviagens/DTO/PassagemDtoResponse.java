package br.com.zup.edu.nossositedeviagens.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PassagemDtoResponse {

    private VoosDtoResponse voo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDateTime horaPartida;

    private BigDecimal valor;

    public VoosDtoResponse getVoo() {
        return voo;
    }

    public LocalDateTime getHoraPartida() {
        return horaPartida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public PassagemDtoResponse(VoosDtoResponse voo, LocalDateTime horaPartida, BigDecimal valor) {
        this.voo = voo;
        this.horaPartida = horaPartida;
        this.valor = valor;
    }
}
