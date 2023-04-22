package exercicios.desafio6.infrastructure.controller;

import exercicios.desafio6.domain.Sanduiche;
import exercicios.desafio6.domain.dto.SanduicheDto;
import exercicios.desafio6.infrastructure.service.SanduicheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sanduiches")
public class SanduicheController {

    private final SanduicheService sanduicheService;

    public SanduicheController(SanduicheService sanduicheService) {
        this.sanduicheService = sanduicheService;
    }

    @PostMapping
    public ResponseEntity<SanduicheDto> criar(@RequestBody SanduicheDto sanduicheDto){
        return ResponseEntity.ok(sanduicheService.criarSanduiche(sanduicheDto));
    }

    @GetMapping
    public ResponseEntity<List<SanduicheDto>> listar(){
        return ResponseEntity.ok(sanduicheService.listarSanduiches());
    }

    @GetMapping("/{chaveParticao}")
    public ResponseEntity<SanduicheDto> buscar(@PathVariable String chaveParticao){
        return ResponseEntity.ok(sanduicheService.buscarSanduiche(chaveParticao));
    }

    @DeleteMapping("/{chaveParticao}")
    public void deletar(@PathVariable String chaveParticao){
        sanduicheService.excluirSanduiche(chaveParticao);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{chaveParticao}")
    public SanduicheDto alterar(@PathVariable String chaveParticao,
                                             @RequestBody SanduicheDto sanduicheDto){
        return sanduicheService.alterarSanduiche(chaveParticao, sanduicheDto);
    }

}

