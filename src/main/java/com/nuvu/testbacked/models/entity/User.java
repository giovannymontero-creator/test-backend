package com.nuvu.testbacked.models.entity;

import java.io.Serializable;

/*------------------------------------------------------------
Descripción: Esta clase configura el usuario con sus credenciales para realizar la petición al servidor de autenticación 
y la obtención del token
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
28/02/2021    Giovanny Montero Beltrán         Creación de la clase						   
*/

public class User implements Serializable{

	private String user;
	private String pwd;
	private String token;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	private static final long serialVersionUID = 1L;

}
