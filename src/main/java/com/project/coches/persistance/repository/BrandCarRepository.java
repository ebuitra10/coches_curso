package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor //crea constructor con los atributos final
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * crud de marca coche
     */
    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;


    /**
     * Devuelve una lista con todas las marcas coches
     * @return lista con marcas coches
     */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }

    /**
     *Devuelve una marca coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::toMarcaCochePojo);
        //(brandCarEntity -> IBrandCarMapper.toMarcasCochePojo(brandCarEntity (funcion lambda)
        //Metodo por referencia iBrandCarMapper::toMarcaCochePojo
    }


    /**
     * guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Elimina una marca de coche dada su id
     * @param idBrandCar id del marca coche a eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }

}


