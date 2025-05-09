package com.Controle_de_Salas.service;

import com.Controle_de_Salas.entity.Sala;
import com.Controle_de_Salas.entity.dto.SalaDTO;
import com.Controle_de_Salas.entity.map.SalaMapper;
import com.Controle_de_Salas.repository.SalaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class SalaService {

    private SalaMapper mapper;
    private SalaRepository salaRepository;

    public List<Sala> listAll(){
        return salaRepository.findAll();
    }

    public Sala findById(String id){

        var uuid = UUID.fromString(id);
        var sala = salaRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return sala;

    }

    public Sala updateSala(SalaDTO dto, String id){

        var uuid = UUID.fromString(id);
        var sala = salaRepository.findById(uuid)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var updateSala = mapper.updateFromDTO(sala, dto);
        return salaRepository.save(updateSala);

    }
}
