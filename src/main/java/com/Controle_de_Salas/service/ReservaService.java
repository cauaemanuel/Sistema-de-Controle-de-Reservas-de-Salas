package com.Controle_de_Salas.service;

import com.Controle_de_Salas.entity.Reserva;
import com.Controle_de_Salas.entity.dto.ReservaDTO;
import com.Controle_de_Salas.entity.map.ReservaFactory;
import com.Controle_de_Salas.repository.ReservaRepository;
import com.Controle_de_Salas.repository.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;
    private SalaRepository salaRepository;

    public ReservaService(ReservaRepository reservaRepository, SalaRepository salaRepository) {
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
    }

    @Transactional
    public Reserva createReserva(String idSala, ReservaDTO dto){
        UUID uuid = UUID.fromString(idSala);
        var sala = salaRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));

        if (dto.dataDeTermino().isBefore(dto.dataDeInicio())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de término não pode ser antes da data de início");
        }
        if (dto.dataDeTermino().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de término não pode estar no passado");
        }
        if (dto.dataDeInicio().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de inicio não pode estar no passado");
        }

        var reserva = ReservaFactory.fromDTO(dto);
        reserva.setSala(sala);
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listFuture() {
        var list = reservaRepository.listFuture();

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma reserva futura encontrada");
        }

        return list;
    }


    public List<ReservaDTO> findBySala(String idSala) {

        UUID uuid = UUID.fromString(idSala);
        var sala = salaRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));
        var list = reservaRepository.findBySalaId(sala.getId());

        if(list.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Essa Sala nao tem reserva");
        }
        return list.stream().map( p -> ReservaFactory.fromEntity(p)).toList();
    }


    @Transactional
    public void cancelarReserva(String id){
        var uuid = UUID.fromString(id);
        var reserva = reservaRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva nao foi encontrada"));
        reservaRepository.delete(reserva);
    }

}
