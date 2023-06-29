package com.project.coches.domain.services;


import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca coche
 */

@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarService {

    /**
     * Repositorio de marca coche
     */
    private final IBrandCarRepository iBrandCarRepository;

    /**
     * Devuelve una marca de coche dada su id
     * @return marca coche
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    /**
     * devuelve una marca coche dada su id
     * @param id Id de marca coche
     * @return optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return marca coche guardada
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }


    /**
     *Actualiza una marca coche
     * @param newBrandCar marca coche a actualizar
     * @return optional con coche a actualizar
     */
    @Override
    public Optional <BrandCarPojo>update(BrandCarPojo newBrandCar) {
        if (iBrandCarRepository.getBrandCar(newBrandCar.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iBrandCarRepository.save(newBrandCar));
    }

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar id del marca coche a eliminar
     * @return si elimino bien el id de la marca coche
     */
    @Override
    public boolean delete(Integer idBrandCar) {

        if (iBrandCarRepository.getBrandCar(idBrandCar).isEmpty()){
            return false;
        }

        iBrandCarRepository.delete(idBrandCar);
        return true;

    }
}
