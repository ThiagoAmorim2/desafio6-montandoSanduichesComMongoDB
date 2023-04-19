package exercicios.desafio6.infrastructure.controller;

import exercicios.desafio6.domain.Sanduiche;
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
    public ResponseEntity<Sanduiche> criar(@RequestBody Sanduiche sanduiche){
        return ResponseEntity.ok(sanduicheService.criarSanduiche(sanduiche));
    }

    @GetMapping
    public ResponseEntity<List<Sanduiche>> listar(){
        return ResponseEntity.ok(sanduicheService.listarSanduiches());
    }

    @GetMapping("/{chaveParticao}")
    public ResponseEntity<Sanduiche> buscar(@PathVariable String chaveParticao){
        return ResponseEntity.ok(sanduicheService.buscarSanduiche(chaveParticao));
    }

    @DeleteMapping("/{chaveParticao}")
    public void deletar(@PathVariable String chaveParticao){
        sanduicheService.excluirSanduiche(chaveParticao);
    }

    @PutMapping("/{chaveParticao}")
    public ResponseEntity<Sanduiche> alterar(@PathVariable String chaveParticao,
                                             @RequestBody Sanduiche sanduiche){
        sanduicheService.alterarSanduiche(chaveParticao, sanduiche);
        return ResponseEntity.accepted().build();
    }

}

