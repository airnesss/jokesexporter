package pl.sdacademy.jokesexporter.controler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.jokesexporter.dto.Joke;
import pl.sdacademy.jokesexporter.exceptions.WrongFormatException;
import pl.sdacademy.jokesexporter.format.FileFormat;
import pl.sdacademy.jokesexporter.jokeService.Generator;
import pl.sdacademy.jokesexporter.jokeService.JokeFactory;
import pl.sdacademy.jokesexporter.jokeService.JokeService;

import java.io.IOException;
@Slf4j
@RestController
public class JokesRestControler {

    @Autowired
    JokeFactory jokeFactory;

    @Autowired
    JokeService jokeService;

    @RequestMapping("/Raport")
    @ResponseBody
    public String requestHeader(@RequestHeader(value = "format") FileFormat format) throws WrongFormatException {
        Generator generate = jokeFactory.generate(format);
        log.info("Controler pierwsze info");
        try {
            generate.generate(jokeService.getJokes());
        } catch (IOException e) {
            log.info("CONTROLERRRRRR");
        }
        return "ok";
    }



}