package com.project.coches.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.coches.domain.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Clase encargada de la creacion y validacion de jwt para el inicio de sesion de un usuario
 */
@Component
public class JwtAuthenticationProvider {

    /**
     * Llave para cifrar el jwt
     */

    @Value("${jwt.secret.key}")
    private String secretKet;

    /**
     * lista blanca con los jwt creados
     */
    private HashMap<String, CustomerDto> listToken = new HashMap<>();


    /**
     * Crea un nuevo JWT en base al cliente recibido por parametro y lo agrega a la lista blanca
     * @param customerJwt Cliente a utilizar en la creacion del jwt
     * @return Jwt creado
     */
    public String createToken(CustomerDto customerJwt){

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);//1 hora en milisegundos

        Algorithm algorithm = Algorithm.HMAC256(secretKet);

        String tokenCreated = JWT.create()
                .withClaim("cardId", customerJwt.getCardId())
                .withClaim("fullName", customerJwt.getFullName())
                .withClaim("numberCellPhone", String.valueOf(customerJwt.getNumberCellphone()))
                .withClaim("email", customerJwt.getEmail())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
        //el password no se guarda en un JWT

        listToken.put(tokenCreated, customerJwt);
        return tokenCreated;

    }

    /**
     * Valida si el token es valido y retorna una sesion del usuario
     * @param token token a validar
     * @return sesion del usuario
     * @throws org.springframework.security.authentication.CredentialsExpiredException si el token ya expiro
     * @throws BadCredentialsException Si el token no existe en la lista blanca
     */

    public Authentication validateToken(String token) throws AuthenticationException{

        System.out.println("entre tambien aqui");
        System.out.println(token);

        //Verifica el token como su firma y expiracion, lanza una excepcion si algo falla
        JWT.require(Algorithm.HMAC256(secretKet)).build().verify(token);

        /*
        El verify ya verifica si el token expiro
        Date dateExpire = decodedJWT.getExpiresAt();

        if(dateExpire.before(new Date()) ){
            listToken.remove(token);
            throw new CredentialsExpiredException( "Ha expirado la sesion");
        }
         */

        CustomerDto exists = listToken.get(token);
        if (exists == null){
            throw new BadCredentialsException("Usuario no registrado.");
        }

        //Creo un UserDetails pero cuando voy a roles() lo que esta es una nueva autoridad con prefijo ROLES_
        UserDetails userTest = User.withUsername(exists.getFullName()).password(exists.getPassword()).roles(exists.getRol()).build();
        userTest.getAuthorities().forEach(System.out::println);

        //return new UsernamePasswordAuthenticationToken(userTest, token, userTest.getAuthorities());

        //return new UsernamePasswordAuthenticationToken(userTest, token, Collections.singletoneList(new SimpleGrantedAuthorization)

        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_"+exists.getRol())); //rol
        rolesAndAuthorities.add(new SimpleGrantedAuthority("WRITE_PRIVILEGE")); //Permisos del rol de prueba

        return new UsernamePasswordAuthenticationToken(exists, token, rolesAndAuthorities);

    }

    public String deleteToken(String jwt){

        if (!listToken.containsKey(jwt)){
            return "No existe token";
        }

        listToken.remove(jwt);
        return "Sesion cerrada exitosamente";

    }
}
