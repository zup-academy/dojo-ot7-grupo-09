package br.com.zup.edu.nossositedeviagens.Model;

import javax.persistence.*;

@Entity
public class Aeroporto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Aeroporto() {
    }

    public Aeroporto(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }
}
