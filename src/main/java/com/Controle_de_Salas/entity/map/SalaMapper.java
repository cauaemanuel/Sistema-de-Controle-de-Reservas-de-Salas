package com.Controle_de_Salas.entity.map;

import com.Controle_de_Salas.entity.Sala;
import com.Controle_de_Salas.entity.dto.SalaDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Sala updateFromDTO(@MappingTarget Sala sala, SalaDTO dto);
}
