package com.Controle_de_Salas.entity.map;

import com.Controle_de_Salas.entity.Sala;
import com.Controle_de_Salas.entity.dto.SalaDTO;

public class SalaFactory {
    public static Sala fromDTO(SalaDTO dto) {
        var sala =  new Sala();
        sala.setLocalizacao(dto.localizacao());
        sala.setCapacidadeMaxima(dto.capcidadeMaxima());
        sala.setNome(dto.nome());
        return sala;
    }

    public static Sala updateFromDTO(Sala sala, SalaDTO dto) {
        if(dto.capcidadeMaxima() != null){
            sala.setCapacidadeMaxima(dto.capcidadeMaxima());
        }

        if (dto.localizacao() != null){
            sala.setLocalizacao(dto.localizacao());
        }

        if (dto.nome() != null){
            sala.setNome(dto.nome());
        }
        return sala;
    }

    public static SalaDTO fromSala(Sala p) {
        return new SalaDTO(p.getNome(), p.getCapacidadeMaxima(), p.getLocalizacao());
    }
}
