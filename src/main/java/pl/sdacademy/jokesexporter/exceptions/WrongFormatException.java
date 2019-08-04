package pl.sdacademy.jokesexporter.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(code = NOT_FOUND, reason = "WRONG FORMAT EXCEPTION")
public class WrongFormatException extends Exception {
    public WrongFormatException(String message) {
        super(message);
    }
}
