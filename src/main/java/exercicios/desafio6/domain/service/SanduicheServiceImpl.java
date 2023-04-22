package exercicios.desafio6.domain.service;

import exercicios.desafio6.domain.Sanduiche;
import exercicios.desafio6.domain.dto.SanduicheDto;
import exercicios.desafio6.domain.repository.SanduicheRepository;
import exercicios.desafio6.infrastructure.service.SanduicheService;
import exercicios.desafio6.utils.mapper.SanduicheMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    public List<SanduicheDto> listarSanduiches() {
        List<Sanduiche> listaSanduicheModel = sanduicheRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        List<SanduicheDto> listaSanduichesDto = mapper.map(listaSanduicheModel, new TypeToken<List<SanduicheDto>>(){}.getType());
        return listaSanduichesDto;
    }

    @Override
    public SanduicheDto buscarSanduiche(String chaveParticao) {
        Sanduiche sanduicheModelLocalizado = sanduicheRepository.findById(chaveParticao).orElseThrow(() -> new RuntimeException(chaveParticao));
        SanduicheDto sanduicheDtoLocalizado = sanduicheMapper.converterSanduicheEmSanduicheDto(sanduicheModelLocalizado);
        return sanduicheDtoLocalizado;
    }

    @Override
    public SanduicheDto criarSanduiche(SanduicheDto sanduicheDto) {
        Sanduiche sanduiche = sanduicheMapper.converterSanduicheDtoEmSanduiche(sanduicheDto);
        sanduicheRepository.save(sanduiche);    
        return sanduicheDto;
    }

    @Override
    public SanduicheDto alterarSanduiche(String id, SanduicheDto sanduiche) {
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
        sanduicheRepository.save(sanduicheParaAlterar);
        SanduicheDto sanduicheDtoAlterado = sanduicheMapper.converterSanduicheEmSanduicheDto(sanduicheParaAlterar);
        return sanduicheDtoAlterado;
    }

    @Override
    public void excluirSanduiche(String chaveParticao) {
        sanduicheRepository.deleteById(chaveParticao);

    }

}
