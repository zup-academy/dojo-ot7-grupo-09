package br.com.zup.edu.nossositedeviagens.Controller;

import br.com.zup.edu.nossositedeviagens.DTO.RotaDtoResponse;
import br.com.zup.edu.nossositedeviagens.DTO.VoosDtoResponse;
import br.com.zup.edu.nossositedeviagens.Form.RotaForm;
import br.com.zup.edu.nossositedeviagens.Form.VoosForm;
import br.com.zup.edu.nossositedeviagens.Model.Rota;
import br.com.zup.edu.nossositedeviagens.Model.Voos;
import br.com.zup.edu.nossositedeviagens.Repository.VoosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/voos")
public class VoosController {

    private final VoosRepository voosRepository;

    public VoosController(VoosRepository voosRepository) {
        this.voosRepository = voosRepository;
    }

    @PostMapping
    public ResponseEntity<VoosDtoResponse> addRota(@RequestBody @Valid VoosForm form, UriComponentsBuilder uriBuilder) {


        Voos voos = form.toModel();
        voosRepository.save(voos);

        URI uri = uriBuilder.path("/voos/{id}").buildAndExpand(voos.getId()).toUri();

        return ResponseEntity.created(uri).body(voos.domainToResponse());

    }
}
