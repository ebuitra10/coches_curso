package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

/*devuelve una lista con todas las marcas de coches*/
    List<BrandCarPojo> getAll();

    /*devuelve una marca coche dada su id*/
    /*optional impide que se llame a la excepcion nullpointerexception para que el programa no se rompa
    (traer un objeto nulo)*/
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCar id del marca coche a eliminar
     */
    void delete(Integer idBrandCar);

}



