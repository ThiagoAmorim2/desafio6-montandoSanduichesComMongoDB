package exercicios.desafio6.domain.service;

import exercicios.desafio6.domain.Sanduiche;
import exercicios.desafio6.domain.repository.SanduicheRepository;
import exercicios.desafio6.infrastructure.service.SanduicheService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SanduicheServiceImpl implements SanduicheService {

    private final SanduicheRepository sanduicheRepository;

    public SanduicheServiceImpl(SanduicheRepository sanduicheRepository) {
        this.sanduicheRepository = sanduicheRepository;
    }

    @Override
    public List<Sanduiche> listarSanduiches() {
        return sanduicheRepository.findAll();
    }

    @Override
    public Sanduiche buscarSanduiche(String chaveParticao) {
        return sanduicheRepository.findById(chaveParticao).orElseThrow(() -> new RuntimeException(chaveParticao));
    }

    @Override
    public Sanduiche criarSanduiche(Sanduiche sanduiche) {
        return sanduicheRepository.save(sanduiche);
    }

    @Override
    public Sanduiche alterarSanduiche(String id, Sanduiche sanduiche) {
        Optional<Sanduiche> sanduicheParaAlterar = sanduicheRepository.findById(id);
        Sanduiche sanduicheAlterado = new Sanduiche();
        sanduicheAlterado.setChaveParticao(sanduicheParaAlterar.get().getChaveParticao());
        BeanUtils.copyProperties(sanduicheParaAlterar, sanduicheAlterado, "chaveParticao");
        return sanduicheAlterado;
    }

    @Override
    public void excluirSanduiche(String chaveParticao) {
        sanduicheRepository.deleteById(chaveParticao);

    }

}
