package com.Controle_de_Salas.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    private String nomeResponsavel;

    private LocalDateTime dataDeInicio;
    private LocalDateTime dataDeTermino;
}
