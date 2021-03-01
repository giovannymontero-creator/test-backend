package com.nuvu.testbacked.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuvu.testbacked.models.dao.ICreditCardDao ;
import com.nuvu.testbacked.models.entity.CreditCard;

/*------------------------------------------------------------
Descripción: Esta clase implementa la interface de servicios para configurar los metodos del CRUD
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la clase de servicios para la tarjeta de credito					   
*/
@Service
public class CreditCardServiceImpl implements ICreditCardService{
	
	@Autowired
	private ICreditCardDao credit_card_dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CreditCard> getAll() {
		
		return (List<CreditCard>) credit_card_dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CreditCard get(Long id) {
		return credit_card_dao.findById(id).orElse(null);
		//return credit_card_dao.findById(id).get();
	}

	@Override
	@Transactional
	public CreditCard save(CreditCard creditCard) {
		return credit_card_dao.save(creditCard);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		credit_card_dao.deleteById(id);	
	}	

}
