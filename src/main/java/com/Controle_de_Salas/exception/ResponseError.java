package com.Controle_de_Salas.exception;

import org.springframework.http.HttpStatus;

public record ResponseError(HttpStatus httpStatus, String message) {
}