package pl.sdacademy.jokesexporter.jokeService;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import pl.sdacademy.jokesexporter.dao.JokeModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JokeServicePDF implements Generator {

    private static final String FILE_NAME = "jokes.pdf";


    @Override
    public void generate(List<JokeModel> jokes) throws IOException {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        try {
            document.add(new Chapter("test", 1));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }

}