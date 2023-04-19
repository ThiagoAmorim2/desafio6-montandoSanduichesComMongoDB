package exercicios.desafio6.domain.repository;

import exercicios.desafio6.domain.Sanduiche;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SanduicheRepository extends MongoRepository<Sanduiche, String>{

}

