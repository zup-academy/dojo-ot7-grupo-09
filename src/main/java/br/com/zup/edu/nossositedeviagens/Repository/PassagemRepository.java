package br.com.zup.edu.nossositedeviagens.Repository;

import br.com.zup.edu.nossositedeviagens.Model.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {
}
