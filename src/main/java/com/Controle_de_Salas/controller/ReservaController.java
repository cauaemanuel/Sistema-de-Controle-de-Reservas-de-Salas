package com.Controle_de_Salas.controller;

import com.Controle_de_Salas.entity.Reserva;
import com.Controle_de_Salas.entity.dto.ReservaDTO;
import com.Controle_de_Salas.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/future")
    public ResponseEntity<List<Reserva>> listFuture(){
        var list = reservaService.listFuture();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/sala/{id}")
    public ResponseEntity<List<ReservaDTO>> findBySala(@PathVariable String id){
        var list = reservaService.findBySala(id);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Reserva> create(@RequestBody @Valid ReservaDTO dto, @PathVariable String id){
        var reserva = reservaService.createReserva(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancellerReserva(@PathVariable String id){
        reservaService.cancelarReserva(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
