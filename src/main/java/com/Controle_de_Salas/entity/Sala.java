package com.Controle_de_Salas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @OneToMany(mappedBy = "sala")
    @JsonManagedReference
    private List<Reserva> reservas;

    private Integer capacidadeMaxima;
    private String localizacao;

}
