package br.com.zup.edu.nossositedeviagens.Controller;

import br.com.zup.edu.nossositedeviagens.DTO.CompanhiaDtoResponse;
import br.com.zup.edu.nossositedeviagens.DTO.PaisDtoResponse;
import br.com.zup.edu.nossositedeviagens.Form.CompanhiaForm;
import br.com.zup.edu.nossositedeviagens.Form.PaisForm;
import br.com.zup.edu.nossositedeviagens.Model.Companhia;
import br.com.zup.edu.nossositedeviagens.Model.Pais;
import br.com.zup.edu.nossositedeviagens.Repository.CompanhiaRepository;
import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/companhia")
public class CompanhiaController {
    private final PaisRepository paisRepository;
    private final CompanhiaRepository companhiaRepository;

    public CompanhiaController(PaisRepository paisRepository, CompanhiaRepository companhiaRepository) {
        this.paisRepository = paisRepository;
        this.companhiaRepository = companhiaRepository;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<CompanhiaDtoResponse> addCompanhia(@RequestBody @Valid CompanhiaForm form, UriComponentsBuilder uriBuilder) {
        Companhia companhia = form.toModel(paisRepository);
        companhiaRepository.save(companhia);

        URI uri = uriBuilder.path("/companhia/{id}").buildAndExpand(companhia.getId()).toUri();
        return ResponseEntity.created(uri).body(new CompanhiaDtoResponse(companhia));
    }
}
