package br.com.zup.edu.nossositedeviagens.Controller;

import br.com.zup.edu.nossositedeviagens.DTO.AeroportoResponseDTO;
import br.com.zup.edu.nossositedeviagens.Form.AeroportoForm;
import br.com.zup.edu.nossositedeviagens.Model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.Repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/aeroporto")
public class AeroportoController {

    private final AeroportoRepository aeroportoRepository;
    private final PaisRepository paisRepository;

    public AeroportoController(AeroportoRepository aeroportoRepository, PaisRepository paisRepository) {
        this.aeroportoRepository = aeroportoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<AeroportoResponseDTO> addAeroporto(@RequestBody @Valid AeroportoForm form, UriComponentsBuilder uriBuilder) {
        Aeroporto aeroporto = form.toModel(paisRepository);
        aeroportoRepository.save(aeroporto);

        URI uri = uriBuilder.path("/aeroporto/{id}").buildAndExpand(aeroporto.getId()).toUri();
        return ResponseEntity.created(uri).body(new AeroportoResponseDTO(aeroporto));
    }
}
