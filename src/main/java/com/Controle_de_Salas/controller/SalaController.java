package com.Controle_de_Salas.controller;

import com.Controle_de_Salas.entity.Sala;
import com.Controle_de_Salas.entity.dto.SalaDTO;
import com.Controle_de_Salas.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<SalaDTO>> findAll(){
        var list = salaService.listAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> findById(@PathVariable String id){
        var sala = salaService.findById(id);
        return ResponseEntity.ok(sala);
    }

    @PostMapping
    public ResponseEntity<Sala> create(@RequestBody @Valid SalaDTO dto){
        var sala = salaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> update(@RequestBody SalaDTO dto,@PathVariable String id){
        var sala = salaService.updateSala(dto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        salaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
