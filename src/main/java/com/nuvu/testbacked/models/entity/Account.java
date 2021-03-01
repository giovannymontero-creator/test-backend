package com.nuvu.testbacked.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/*------------------------------------------------------------
Descripción: Esta clase configura la cuenta bancaria con las anotaciones JPA para poder ser mapeada como una tabla de base de datos 
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la entidad cuenta					   
*/
@Entity
@Table(name="accounts")
public class Account implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long account_number;
	@Temporal(TemporalType.DATE)
	private Date open_date;
	private byte status;
	private String account_type;
	private String bank;
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name="identification_number")
	private Customer customer;
	
	@JsonManagedReference
	@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
	private CreditCard credit_card;
	
	@PrePersist
	public void prePersist() {
		this.open_date = new Date();
	}

	public Long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CreditCard getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(CreditCard credit_card) {
		this.credit_card = credit_card;
	}
	
	private static final long serialVersionUID = 1L;

}
