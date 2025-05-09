package com.Controle_de_Salas.repository;

import com.Controle_de_Salas.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalaRepository extends JpaRepository<Sala, UUID> {
}
