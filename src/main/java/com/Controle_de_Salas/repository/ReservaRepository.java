package com.Controle_de_Salas.repository;

import com.Controle_de_Salas.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {

    List<Reserva> findBySalaId(UUID id);

    @Query("SELECT r FROM Reserva r WHERE r.dataDeInicio > CURRENT_TIMESTAMP")
    List<Reserva> listFuture();

}
