package com.Controle_de_Salas.entity.dto;

import jakarta.validation.constraints.NotBlank;

public record SalaDTO (@NotBlank String nome,
                       @NotBlank Integer capcidadeMaxima,
                       @NotBlank String localizacao){
}
