package pl.sdacademy.jokesexporter.jokeService;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sdacademy.jokesexporter.dao.JokeModel;
import pl.sdacademy.jokesexporter.dto.Joke;
import pl.sdacademy.jokesexporter.repository.JokeRepository;

import java.util.List;

@Component
public class JokeService {

    @Autowired
    JokeRepository jokeRepository;

    public List<JokeModel> getJokes() {
        return jokeRepository.findAll();

    }

}

