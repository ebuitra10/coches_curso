package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {

    List<CarDto> getAll();

    List<CarDto> getByIdBrandCar(Integer idCar);

    List<CarDto> getAllByPriceLessThan(Double price);

    Optional<CarDto> getCar(Integer idCar);

    CarDto save(CarDto newCar);

    boolean delete(Integer idCar);

}
