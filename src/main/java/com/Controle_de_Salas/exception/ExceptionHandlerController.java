package com.Controle_de_Salas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ResponseStatusException.class)
    protected ResponseEntity<Object> responseStatusException(ResponseStatusException ex, WebRequest request) {
        var responseError = new ResponseError((HttpStatus) ex.getStatusCode(), ex.getReason());
        return ResponseEntity.status(ex.getStatusCode()).body(responseError);
    }

}
