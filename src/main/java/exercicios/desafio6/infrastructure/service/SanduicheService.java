package exercicios.desafio6.infrastructure.service;

import exercicios.desafio6.domain.Sanduiche;
import exercicios.desafio6.domain.dto.SanduicheDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SanduicheService {

    List<SanduicheDto> listarSanduiches();

    SanduicheDto buscarSanduiche(String id);

    SanduicheDto criarSanduiche(SanduicheDto sanduicheDto);

    SanduicheDto alterarSanduiche(String id, SanduicheDto sanduiche);

    void excluirSanduiche(String id);

}
