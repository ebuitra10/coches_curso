package com.project.coches.domain.services;

import com.project.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

        List<BrandCarDto> getAll();


        /*devuelve una lista con todas las marcas de coches*/



        Optional<BrandCarDto> getBrandCar(Integer id);

        /**
         * guarda una nueva marca coche
         *
         * @param newBrandCar Marca coche a guardar
         * @return Marca coche guardada
         */
        BrandCarDto save(BrandCarDto newBrandCar);


        /**
         * Actuliza una marca cocge
         * @param newBrandCar marca coche a actualizar
         * @return Marca coche actualizada
         */
        Optional <BrandCarDto> update(BrandCarDto newBrandCar);

        /**
         * Elimina una marca coche dado su id
         *
         * @param idBrandCar id del marca coche a eliminar
         */
        boolean delete(Integer idBrandCar);
    }


