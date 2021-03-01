package com.nuvu.testbacked.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*------------------------------------------------------------
Descripción: Esta clase configura el cliente con las anotaciones JPA para poder ser mapeada como una tabla de base de datos 
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la entidad cliente				   
*/
@Entity
@Table(name="customers")
public class Customer implements Serializable{
	
	@Id
	private String identification_number;
	private String identification_type;
	private String name;
	private String last_name;
	private String email;
	private String cell_phone_number;
	private String address;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set <Account> accounts;

	public String getIdentification_number() {
		return identification_number;
	}

	public void setIdentification_number(String identification_number) {
		this.identification_number = identification_number;
	}

	public String getIdentification_type() {
		return identification_type;
	}

	public void setIdentification_type(String identification_type) {
		this.identification_type = identification_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell_phone_number() {
		return cell_phone_number;
	}

	public void setCell_phone_number(String cell_phone_number) {
		this.cell_phone_number = cell_phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	private static final long serialVersionUID = 1L;

}
