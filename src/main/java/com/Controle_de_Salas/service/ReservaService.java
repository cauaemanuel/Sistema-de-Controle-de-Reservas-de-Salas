package com.Controle_de_Salas.service;

import com.Controle_de_Salas.entity.Reserva;
import com.Controle_de_Salas.entity.dto.ReservaDTO;
import com.Controle_de_Salas.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void createReserva(String idSala, ReservaDTO dto){
    }

    public List<Reserva> listFuture(){
        return null;
    }


    public Reserva findBySala(String idSala){
        return null;
    }

    public void cancelarReserva(String id){
    }

    /*criar reserva, Listar reservas futuras, por sala, cancelar reserva
    uma sala nao pode ter duas reservas sobrepostas;
    a data de termino nao dev ser anterior a de inicio;
    nao pode agendar para o passado;
     */
}
