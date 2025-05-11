package com.Controle_de_Salas.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaDTO (@NotBlank String nome,
                       @NotNull Integer capcidadeMaxima,
                       @NotBlank String localizacao){
}
