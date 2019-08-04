package pl.sdacademy.jokesexporter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.jokesexporter.dao.JokeModel;

import java.util.List;
import java.util.Optional;

public interface JokeRepository extends MongoRepository<JokeModel, Integer> {



}
