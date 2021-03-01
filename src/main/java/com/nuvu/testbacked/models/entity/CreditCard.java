package com.nuvu.testbacked.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*------------------------------------------------------------
Descripción: Esta clase configura la tarjeta de credito bancaria con las anotaciones JPA para poder ser mapeada como una tabla de base de datos 
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la entidad tarjeta de credito					   
*/
@Entity
@Table(name="credit_cards")
public class CreditCard implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long card_number;
	private Date expired_date;
	private int cvv;
	private String credit_card_type;
	private byte status;
	@JsonBackReference
	@OneToOne()
	@JoinColumn(name="account_number")
	private Account account;

	public Long getCard_number() {
		return card_number;
	}

	public void setCard_number(Long card_number) {
		this.card_number = card_number;
	}

	public Date getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(Date expired_date) {
		this.expired_date = expired_date;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCredit_card_type() {
		return credit_card_type;
	}

	public void setCredit_card_type(String credit_card_type) {
		this.credit_card_type = credit_card_type;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	private static final long serialVersionUID = 1L;
	
}
