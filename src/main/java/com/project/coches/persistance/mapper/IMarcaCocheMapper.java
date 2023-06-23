package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.MarcaCochePojo;
import com.project.coches.persistance.entity.MarchaCocheEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
//Mapper para mapear entre entidades a pojos y pojos a entidades

/*le vamos a decir que es un componente de spring, es un objeto manejado por spring
para posterior/ inyectar esta interfaz*/
/*mapper que transforma objetos de marcacoche y pojos a entidades*/
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /*convierte una entidad a un pojo de marcaCoche*/
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCochePojo toMarcaCochePojo(MarchaCocheEntity marcaEntity);

    //este inverse es para no tener que hacer lo mismo de arriba y optimizar codigo
    @InheritInverseConfiguration
    MarchaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaPojo);

    /*Retorna una lista de marcas coches transformada a pojo de una lista de entidades
    y me retorna una lista transformada*/
    List<MarcaCochePojo> toMarcasCochePojo(List<MarchaCocheEntity> marcasCocheEntity);

}
