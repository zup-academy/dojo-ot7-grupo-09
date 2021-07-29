package br.com.zup.edu.nossositedeviagens.Controller;

import br.com.zup.edu.nossositedeviagens.DTO.RotaResponse;
import br.com.zup.edu.nossositedeviagens.Form.RotaForm;
import br.com.zup.edu.nossositedeviagens.Model.Rota;
import br.com.zup.edu.nossositedeviagens.Repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.Repository.RotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/rota")
public class RotaController {

    private final RotaRepository repository;
    private final AeroportoRepository aeroportoRepository;

    public RotaController(RotaRepository repository, AeroportoRepository aeroportoRepository) {
        this.repository = repository;
        this.aeroportoRepository = aeroportoRepository;
    }

    @PostMapping
    public ResponseEntity<RotaResponse> addRota(@RequestBody @Valid RotaForm rotaForm, UriComponentsBuilder uriBuilder) {


        Rota rota = repository.save(rotaForm.formToModel(aeroportoRepository));

        URI uri = uriBuilder.path("/rota/{id}").buildAndExpand(rota.getId()).toUri();

        return ResponseEntity.created(uri).body(rota.domainToResponse());

    }
}
