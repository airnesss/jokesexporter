package pl.sdacademy.jokesexporter.jokeService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sdacademy.jokesexporter.dao.JokeModel;
import pl.sdacademy.jokesexporter.exceptions.ReportingException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JokeServiceCSV implements Generator {
    @Override
    public void generate(List<JokeModel> jokes) {
        log.info("zarciki");
        try {
            FileWriter fileWriter = new FileWriter("jokes.csv");
            try (CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.
                    withHeader("ID", "JOKE", "CATEGORY"))) {
                jokes.forEach(joke -> {
                    try {
                        csvPrinter.printRecord(
                                joke.getId(),
                                joke.getValue(),
                                String.join("_", joke.getCategories()));
                    } catch (IOException e) {
                        log.error("Sth wrong happened during csv export");
                        throw new ReportingException();
                    }
                });
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("SUKCESSSSS");
    }
}
