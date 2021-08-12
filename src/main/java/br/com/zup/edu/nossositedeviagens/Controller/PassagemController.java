package br.com.zup.edu.nossositedeviagens.Controller;

import br.com.zup.edu.nossositedeviagens.DTO.AeroportoDtoResponse;
import br.com.zup.edu.nossositedeviagens.Form.PassagemForm;
import br.com.zup.edu.nossositedeviagens.Model.Passagem;
import br.com.zup.edu.nossositedeviagens.Repository.PassagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/passagens")
public class PassagemController {

    private PassagemRepository passagemRepository;

    public PassagemController(PassagemRepository passagemRepository) {
        this.passagemRepository = passagemRepository;
    }

    public ResponseEntity<?> cadastrar(@RequestBody @Valid PassagemForm passagemForm, UriComponentsBuilder uriBuilder) {

        Passagem passagem = passagemForm.formToModel();
        passagemRepository.save(passagem);


        URI uri = uriBuilder.path("/passagens/{id}").buildAndExpand(passagem.getId()).toUri();
        return ResponseEntity.created(uri).body(passagem.domainToResponse());
    }

}
