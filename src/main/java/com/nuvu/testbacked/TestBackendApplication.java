package com.nuvu.testbacked;

import org.springframework.boot.SpringApplication;//
import org.springframework.boot.autoconfigure.SpringBootApplication;//
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nuvu.testbacked.security.JWTAuthorizationFilter;

/*------------------------------------------------------------
Descripción: Este controlador REST se crea para implementar el proceso de autenticación mediante un login usuario/contraseña
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de clase principal con Sprig booot						   
*/
@SpringBootApplication
public class TestBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBackendApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/user").permitAll()
				.anyRequest().authenticated();
		}
	}
	
	/*
	la clase interna WebSecurityConfig nos permite especificar la configuración de acceso a los recursos publicados. 
	En este caso se permiten todas las llamadas al controlador /api/user, pero el resto de las llamadas requieren autenticación 
	*/

}
