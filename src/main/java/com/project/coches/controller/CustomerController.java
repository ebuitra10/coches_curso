package com.project.coches.controller;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;


    @GetMapping//Si yo no le paso ninguna ruta supone que va con la ruta del customers
    public ResponseEntity<List<CustomerDto>> getAll() {
        /*El responseEntity envuelve lo que se vaya a retornar y el codigo http. El getmapping es
        para indicar el codigo  en la anotacion de arriba*/
        return ResponseEntity.status(HttpStatus.OK).body(iCustomerUseCase.getAll());
    }


    @GetMapping(path = "/{cardId}")                 //indica que viene una variable
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId) { //ese parametro viene en la ruta, en el path
        return ResponseEntity.of(iCustomerUseCase.getCustomerByCardId(cardId));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    @PostMapping //Si es un save utilizo esta anotacion
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCustomerUseCase.save(customerDtoNew));

    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate) {

        return ResponseEntity.of(iCustomerUseCase.update(customerDtoUpdate));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId) {
        return new ResponseEntity<>(this.iCustomerUseCase.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
