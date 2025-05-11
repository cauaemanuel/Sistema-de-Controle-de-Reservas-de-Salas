package com.Controle_de_Salas.service;

import com.Controle_de_Salas.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


}
