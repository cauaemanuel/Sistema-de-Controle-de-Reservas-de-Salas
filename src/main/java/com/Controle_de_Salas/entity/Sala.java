package com.Controle_de_Salas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_sala")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String nome;
    private Integer capacidadeMaxima;
    private String localizacao;

}
