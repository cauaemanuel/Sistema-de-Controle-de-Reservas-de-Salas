package com.Controle_de_Salas.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaDTO (
        @NotBlank(message = "O campo NOME deve ser preenchido") String nome,
        @NotNull(message = "O campo de CAPACIDADE Maxima não pode ser Null") Integer capacidadeMaxima,
        @NotBlank(message = "O campo LOCALIZAÇÃO deve ser preenchido") String localizacao
){}
