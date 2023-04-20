package exercicios.desafio6.utils.mapper;

import exercicios.desafio6.domain.Sanduiche;
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
}
