package exercicios.desafio6.infrastructure.service;

import exercicios.desafio6.domain.Sanduiche;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SanduicheService {

    List<Sanduiche> listarSanduiches();

    Sanduiche buscarSanduiche(String id);

    Sanduiche criarSanduiche(Sanduiche sanduiche);

    Sanduiche alterarSanduiche(String id, Sanduiche sanduiche);

    void excluirSanduiche(String id);

}
