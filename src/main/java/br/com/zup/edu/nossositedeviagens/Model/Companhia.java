package br.com.zup.edu.nossositedeviagens.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Companhia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String nome;
    private LocalDateTime instante = LocalDateTime.now();
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Companhia() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public Pais getPais() {
        return pais;
    }

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
