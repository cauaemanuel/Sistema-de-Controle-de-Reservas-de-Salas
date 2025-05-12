package com.Controle_de_Salas.repository;

import com.Controle_de_Salas.entity.Reserva;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {

    List<Reserva> findBySalaId(UUID id);

    @Query("SELECT r FROM Reserva r WHERE r.dataDeInicio > CURRENT_TIMESTAMP")
    List<Reserva> listFuture();

    @Transactional
    @Modifying
    @Query("DELETE FROM Reserva r WHERE r.dataDeTermino < :dateTime")
    void checkAndRemove(@Param("dateTime") LocalDateTime dateTime);
}
