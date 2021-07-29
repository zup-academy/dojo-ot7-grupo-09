package br.com.zup.edu.nossositedeviagens.Model;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EnableJpaRepositories
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Aeroporto aeroportoOrigem;

    private Aeroporto aeroportoDestino;
}
