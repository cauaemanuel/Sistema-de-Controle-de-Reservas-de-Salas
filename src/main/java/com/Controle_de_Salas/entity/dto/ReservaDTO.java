package com.Controle_de_Salas.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;


public record ReservaDTO(

        @NotBlank(message = "O nome do responsável não pode estar em branco.")
        String nomeResponsavel,

        @NotNull(message = "A data de início é obrigatória.")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataDeInicio,

        @NotNull(message = "A data de término é obrigatória.")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataDeTermino

) {}
