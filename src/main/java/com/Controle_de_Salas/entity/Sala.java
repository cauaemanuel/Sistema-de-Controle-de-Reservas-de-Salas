package com.Controle_de_Salas.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_sala")
@NoArgsConstructor
@Getter
@Setter
@Data
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer capacidadeMaxima;
    private String localizacao;

}
