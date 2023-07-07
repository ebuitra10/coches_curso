package com.project.coches.controller;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cars")
@RequiredArgsConstructor
public class CarController {

    private final ICarUseCase iCarUseCase;

    @GetMapping//Si yo no le paso ninguna ruta supone que va con la ruta del customers
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(iCarUseCase.getAll());
    }

    @GetMapping(path = "/brand-car/{idBrandCar}")
    public ResponseEntity<List<CarDto>> getCarByIdBrandCar(@PathVariable Integer idBrandCar) { //ese parametro viene en la ruta, en el path
        return ResponseEntity.ok(iCarUseCase.getByIdBrandCar(idBrandCar));
    }

    @GetMapping(path = "/price/{priceCar}")
    public ResponseEntity<List<CarDto>> getCarByPriceLessThan(@PathVariable Double priceCar) { //ese parametro viene en la ruta, en el path
        return ResponseEntity.ok(iCarUseCase.getAllByPriceLessThan(priceCar));
    }

    @GetMapping(path = "/{idCar}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer idCar) { //ese parametro viene en la ruta, en el path
        return ResponseEntity.of(iCarUseCase.getCar(idCar));
    }


    @PostMapping //Si es un save utilizo esta anotacion
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDtoNew) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCarUseCase.save(carDtoNew));

    }


    @DeleteMapping(path = "/{carId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer carId) {
        return new ResponseEntity<>(this.iCarUseCase.delete(carId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }







}
