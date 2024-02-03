package com.cybage.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException{

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;
}
