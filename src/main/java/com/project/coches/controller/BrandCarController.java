package com.project.coches.controller;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.services.BrandCarService;
import com.project.coches.domain.services.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador rest de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private final IBrandCarService iBrandCarService;


    /**
     * Devuelve lista de marcas coche
     * @return HttpCode Ok con lista de marcas coche
     */
    @GetMapping//Si yo no le paso ninguna ruta supone que va con la ruta del padre marcas coches
    public ResponseEntity<List<BrandCarPojo>> getAll(){
        /*El responseEntity envuelve lo que se vaya a retornar y el codigo http. El getmapping es
        para indicar el codigo  en la anotacion de arriba*/
        return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll());
    }

    /**
     * Devuelve marca coche dado su Id
     * @param id Id de la marca coche a buscar
     * @return HttpCode Ok si la encuentra, HttpCode Not found de lo contrario
     */
    @GetMapping(path = "/{id}")                 //indica que viene una variable
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){ //ese parametro viene en la ruta, en el path
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
     * @param brandCarPojoNew Marca coche a crear
     * @return HttpCode Created si la guarda correctamente, HttpCode BadRquest de lo contrario
     */
    @PostMapping //Si es un save utilizo esta anotacion
    public ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo brandCarPojoNew){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojoNew));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Actualiza una marca coche
     * @param brandCarPojoUpdate marca coche actualizada
     * @return HttpCode Ok si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate){

        return ResponseEntity.of(iBrandCarService.update(brandCarPojoUpdate));
    }

    /**
     * Elimina una marca coche dada su Id
     * @param id Id de la marca coche a eliminar
     * @return HttpCode Ok si la elimina, HttpCode not found si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity <Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }



}
