package pl.sdacademy.jokesexporter.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document("jokes") //info ze to bedzie dao MONGO
@Data
@Builder
public class JokeModel {
    Integer id;
    Integer externalId;
    String value;
    List<String>categories = new ArrayList<>();
}