package com.Controle_de_Salas.service;

import com.Controle_de_Salas.entity.Sala;
import com.Controle_de_Salas.entity.dto.SalaDTO;
import com.Controle_de_Salas.entity.map.SalaFactory;
import com.Controle_de_Salas.repository.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class SalaService {


    private SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<SalaDTO> listAll(){
        var salas = salaRepository.findAll().stream()
                .map(p -> SalaFactory.fromSala(p)).toList();
        if(salas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return salas;
    }

    @Transactional
    public Sala create(SalaDTO dto){
       var sala =  SalaFactory.fromDTO(dto);
       return salaRepository.save(sala);
    }


    public Sala findById(String id){
        var uuid = UUID.fromString(id);
        var sala = salaRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A Sala não foi encontrada; Verifique o ID"));
        return sala;
    }

    @Transactional
    public void deleteById(String id){
        var uuid = UUID.fromString(id);
        var sala = salaRepository.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A Sala não foi encontrada; Verifique o ID"));

        salaRepository.deleteById(uuid);
    }

    @Transactional
    public Sala updateSala(SalaDTO dto, String id){
        var uuid = UUID.fromString(id);
        var sala = salaRepository.findById(uuid)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id invalido"));

        var updateSala = SalaFactory.updateFromDTO(sala, dto);
        return salaRepository.save(updateSala);
    }
}
