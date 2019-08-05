package pl.sdacademy.jokesexporter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.sdacademy.jokesexporter.dao.JokeModel;

public interface JokeRepository extends MongoRepository<JokeModel, Integer> {
}
