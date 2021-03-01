package com.nuvu.testbacked.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.testbacked.models.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*------------------------------------------------------------
Descripción: Este controlador REST se crea para implementar el proceso de autenticación mediante un login usuario/contraseña
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
28/02/2021    Giovanny Montero Beltrán         Creación de la clase controlador						   
*/

@RestController
@RequestMapping("/api")
public class UserController {
	//El método login intercepta las peticiones POST al endpoint /user y recibe como parámetros el usuario y contraseña
	@PostMapping("/user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}
	/*El método getJWTToken se usa para construir el token, delegando en la clase de utilidad Jwts que incluye información 
	 * sobre su expiración y un objeto de GrantedAuthority de Spring que se usa para autorizar las peticiones a los recursos protegidos*/ 
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}

