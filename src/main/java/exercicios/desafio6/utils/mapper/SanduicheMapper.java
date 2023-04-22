package exercicios.desafio6.utils.mapper;

import exercicios.desafio6.domain.Sanduiche;
import exercicios.desafio6.domain.dto.SanduicheDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SanduicheMapper {
    public Sanduiche converterOptionalEmSanduiche(Optional<Sanduiche> sanduicheOptional){
        Sanduiche sanduiche = new Sanduiche();
        sanduiche.setChaveFiltragem(sanduicheOptional.get().getChaveFiltragem());
        sanduiche.setDataAtualizacao(sanduicheOptional.get().getDataAtualizacao());
        sanduiche.setTipoDePao(sanduicheOptional.get().getTipoDePao());
        sanduiche.setProteina(sanduicheOptional.get().getProteina());
        sanduiche.setAlface(sanduicheOptional.get().getAlface());
        sanduiche.setTomate(sanduicheOptional.get().getTomate());
        sanduiche.setQueijo(sanduicheOptional.get().getQueijo());
        sanduiche.setPicles(sanduicheOptional.get().getPicles());
        return sanduiche;
    }

    public Sanduiche converterSanduicheDtoEmSanduiche(SanduicheDto sanduicheDto){
        Sanduiche sanduicheModel = new Sanduiche();
        sanduicheModel.setChaveParticao(sanduicheDto.getChaveParticao());
        sanduicheModel.setChaveFiltragem(sanduicheDto.getChaveFiltragem());
        sanduicheModel.setDataAtualizacao(sanduicheDto.getDataAtualizacao());
        sanduicheModel.setTipoDePao(sanduicheDto.getTipoDePao());
        sanduicheModel.setProteina(sanduicheDto.getProteina());
        sanduicheModel.setAlface(sanduicheDto.getAlface());
        sanduicheModel.setTomate(sanduicheDto.getTomate());
        sanduicheModel.setQueijo(sanduicheDto.getQueijo());
        sanduicheModel.setPicles(sanduicheDto.getPicles());
        return sanduicheModel;
    }

    public SanduicheDto converterSanduicheEmSanduicheDto(Sanduiche sanduicheModel){
        SanduicheDto sanduicheDto = new SanduicheDto();
        sanduicheDto.setChaveParticao(sanduicheModel.getChaveParticao());
        sanduicheDto.setChaveFiltragem(sanduicheModel.getChaveFiltragem());
        sanduicheDto.setDataAtualizacao(sanduicheModel.getDataAtualizacao());
        sanduicheDto.setTipoDePao(sanduicheModel.getTipoDePao());
        sanduicheDto.setProteina(sanduicheModel.getProteina());
        sanduicheDto.setAlface(sanduicheModel.getAlface());
        sanduicheDto.setTomate(sanduicheModel.getTomate());
        sanduicheDto.setQueijo(sanduicheModel.getQueijo());
        sanduicheDto.setPicles(sanduicheModel.getPicles());
        return sanduicheDto;
    }
}
