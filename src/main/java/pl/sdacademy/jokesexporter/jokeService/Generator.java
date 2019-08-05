package pl.sdacademy.jokesexporter.jokeService;

import pl.sdacademy.jokesexporter.dao.JokeModel;

import java.io.IOException;
import java.util.List;

public interface Generator {
    void generate(List<JokeModel> jokes) throws IOException;

}


