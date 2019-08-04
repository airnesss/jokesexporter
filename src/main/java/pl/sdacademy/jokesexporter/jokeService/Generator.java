package pl.sdacademy.jokesexporter.jokeService;

import org.springframework.stereotype.Component;
import pl.sdacademy.jokesexporter.dao.JokeModel;
import pl.sdacademy.jokesexporter.dto.Joke;
import pl.sdacademy.jokesexporter.format.FileFormat;

import java.io.IOException;
import java.util.List;

public interface Generator {

    void generate(List<JokeModel> jokes) throws IOException;

}


