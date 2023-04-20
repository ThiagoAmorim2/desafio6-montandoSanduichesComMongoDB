package exercicios.desafio6.domain.service;

import exercicios.desafio6.domain.Sanduiche;
import exercicios.desafio6.domain.repository.SanduicheRepository;
import exercicios.desafio6.infrastructure.service.SanduicheService;
import exercicios.desafio6.utils.mapper.SanduicheMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SanduicheServiceImpl implements SanduicheService {

    private final SanduicheRepository sanduicheRepository;
    private final SanduicheMapper sanduicheMapper;

    public SanduicheServiceImpl(SanduicheRepository sanduicheRepository, SanduicheMapper sanduicheMapper) {
        this.sanduicheRepository = sanduicheRepository;
        this.sanduicheMapper = sanduicheMapper;
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
        Optional<Sanduiche> sanduicheOptional = sanduicheRepository.findById(id);
        Sanduiche sanduicheParaAlterar = sanduicheMapper.converterOptionalEmSanduiche(sanduicheOptional);
        sanduicheParaAlterar.setChaveParticao(id);
        sanduicheParaAlterar.setPicles(sanduiche.getPicles());
        sanduicheParaAlterar.setQueijo(sanduiche.getQueijo());
        sanduicheParaAlterar.setAlface(sanduiche.getAlface());
        sanduicheParaAlterar.setTomate(sanduiche.getTomate());
        sanduicheParaAlterar.setProteina(sanduiche.getProteina());
        sanduicheParaAlterar.setDataAtualizacao(sanduiche.getDataAtualizacao());
        sanduicheParaAlterar.setTipoDePao(sanduiche.getTipoDePao());
        sanduicheParaAlterar.setChaveFiltragem(sanduiche.getChaveFiltragem());
        return sanduicheRepository.save(sanduicheParaAlterar);
    }

    @Override
    public void excluirSanduiche(String chaveParticao) {
        sanduicheRepository.deleteById(chaveParticao);

    }

}
