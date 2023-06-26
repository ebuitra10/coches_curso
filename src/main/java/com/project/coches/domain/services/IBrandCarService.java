package com.project.coches.domain.services;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

        List<BrandCarPojo> getAll();


        /*devuelve una lista con todas las marcas de coches*/



        Optional<BrandCarPojo> getBrandCar(Integer id);

        /**
         * guarda una nueva marca coche
         *
         * @param newBrandCar Marca coche a guardar
         * @return Marca coche guardada
         */
        BrandCarPojo save(BrandCarPojo newBrandCar);

        /**
         * Elimina una marca coche dado su id
         *
         * @param idBrandCar id del marca coche a eliminar
         */
        boolean delete(Integer idBrandCar);
    }


