package com.hah.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TimestampNotExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TimestampNotExistsException(String message) {
        super(message);
    }
}
