package pl.sdacademy.jokesexporter.reporting;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;
import pl.sdacademy.jokesexporter.dao.JokeModel;
import pl.sdacademy.jokesexporter.exceptions.ReportingException;
import pl.sdacademy.jokesexporter.exceptions.WrongFormatException;
import pl.sdacademy.jokesexporter.jokeService.Generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class CsvExporter implements Generator {

    @Override
    public void generate(List<JokeModel> jokes) throws IOException {
        FileWriter fileWriter = new FileWriter("jokes.csv");
        try (CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.
                withHeader("ID", "JOKE", "CATEGORY"))) {
            jokes.forEach(joke -> {
                try {
                    csvPrinter.printRecord(
                            joke.getId(),
                            joke.getValue(),
                            Arrays.toString(joke.getCategories().toArray()));
                } catch (IOException e) {
                    log.error("Sth wrong happened during csv export");
                    throw new ReportingException();
                }
            });
        }
log.info("SUKCESSSSS");
    }

   
}

