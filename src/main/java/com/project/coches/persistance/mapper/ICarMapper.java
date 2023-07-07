package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.persistance.entity.CarEntity;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    CarDto toCarDto(CarEntity carEntity);


    //Se ignora con esa anotacion el brandcarentity del CarEntity porque hay que ignorar ese objeto
    @Mapping(target = "brandCarEntity", ignore = true)
    @Mapping(target = "carPurchaseEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarDto(List<CarEntity> carEntityList);

}
