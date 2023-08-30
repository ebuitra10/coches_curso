package com.project.coches.controller;


import com.project.coches.domain.dto.AuthCustomerDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.JwtResponseDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.useCase.IAuthUseCase;
import com.project.coches.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final IAuthUseCase iAuthUseCase;

    private final ICustomerUseCase iCustomerUseCase;


    @PostMapping(path = "/register") //Si es un save utilizo esta anotacion
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCustomerUseCase.save(customerDtoNew));

    }

    @GetMapping()
    public ResponseEntity<JwtResponseDto> prueba(){
        return ResponseEntity.ok(new JwtResponseDto("prueba"));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto authCustomerDto){
        return ResponseEntity.ok(iAuthUseCase.singIn(authCustomerDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity <JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION)String jwt){
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
