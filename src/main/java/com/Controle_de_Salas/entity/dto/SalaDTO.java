package com.Controle_de_Salas.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaDTO (@NotBlank(message = "O campo NOME não deve ser NULL") String nome,
                       @NotNull Integer capacidadeMaxima,
                       @NotBlank String localizacao){
}
