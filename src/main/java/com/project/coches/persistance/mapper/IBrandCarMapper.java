package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Repository;

import java.util.List;
//Mapper para mapear entre entidades a pojos y pojos a entidades

/*le vamos a decir que es un componente de spring, es un objeto manejado por spring
para posterior/ inyectar esta interfaz*/
/*mapper que transforma objetos de marcacoche y pojos a entidades*/
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    /*convierte una entidad a un pojo de marcaCoche*/
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarPojo toMarcaCochePojo(BrandCarEntity marcaEntity);

    //este inverse es para no tener que hacer lo mismo de arriba y optimizar codigo
    @InheritInverseConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarPojo marcaPojo);

    /*Retorna una lista de marcas coches transformada a pojo de una lista de entidades
    y me retorna una lista transformada*/
    List<BrandCarPojo> toMarcasCochePojo(List<BrandCarEntity> marcasCocheEntity);

}
