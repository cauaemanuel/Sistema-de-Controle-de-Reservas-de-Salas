package com.Controle_de_Salas.entity.map;

import com.Controle_de_Salas.entity.Reserva;
import com.Controle_de_Salas.entity.dto.ReservaDTO;

public class ReservaFactory {


    public static Reserva fromDTO(ReservaDTO dto) {
        var reserva = new Reserva();
        reserva.setDataDeInicio(dto.dataDeInicio());
        reserva.setDataDeTermino(dto.dataDeTermino());
        reserva.setNomeResponsavel(dto.nomeResponsavel());
        return reserva;
    }

    public static ReservaDTO fromEntity(Reserva p) {
        return new ReservaDTO(p.getNomeResponsavel(),
                p.getDataDeInicio(),
                p.getDataDeTermino());
    }
}
