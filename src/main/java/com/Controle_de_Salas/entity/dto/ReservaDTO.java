package com.Controle_de_Salas.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

public record ReservaDTO(@NotBlank String idSala,
                         @NotBlank String nomeResponsavel,
                         @NotNull
                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                         LocalDateTime dataDeInicio,
                         @NotNull
                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                         LocalDateTime dataDeTermino)  {
}
