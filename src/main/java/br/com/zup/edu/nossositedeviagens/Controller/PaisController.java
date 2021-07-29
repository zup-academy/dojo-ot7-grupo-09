package br.com.zup.edu.nossositedeviagens.Controller;

import br.com.zup.edu.nossositedeviagens.DTO.PaisDtoResponse;
import br.com.zup.edu.nossositedeviagens.Form.PaisForm;
import br.com.zup.edu.nossositedeviagens.Model.Pais;
import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PaisDtoResponse> post(@RequestBody @Valid PaisForm form, UriComponentsBuilder uriBuilder) {
    Pais pais = form.toModel();
        paisRepository.save(pais);

    URI uri = uriBuilder.path("/pais/{id}").buildAndExpand(pais.getId()).toUri();
    return ResponseEntity.created(uri).body(new PaisDtoResponse(pais));
}
}
