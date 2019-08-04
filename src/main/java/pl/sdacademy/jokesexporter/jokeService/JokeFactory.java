package pl.sdacademy.jokesexporter.jokeService;

import org.springframework.stereotype.Component;
import pl.sdacademy.jokesexporter.exceptions.WrongFormatException;
import pl.sdacademy.jokesexporter.format.FileFormat;

@Component

public class JokeFactory {

    public Generator generate(FileFormat format) throws WrongFormatException {
        switch (format) {
            case CSV:
                return new JokeServiceCSV();

            case PDF:
                return new JokeServicePDF();

            case EXCEL:
                return new JokeServiceEXEL();

            default:
                throw new WrongFormatException("WAL SIE PEDALE");
        }
    }

}
