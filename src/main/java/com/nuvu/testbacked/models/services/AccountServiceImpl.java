package com.nuvu.testbacked.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuvu.testbacked.models.dao.IAccountDao ;
import com.nuvu.testbacked.models.entity.Account;

/*------------------------------------------------------------
Descripción: Esta clase implementa la interface de servicios para configurar los metodos del CRUD
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la clase de servicios para la cuenta bancaria					   
*/
@Service
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	private IAccountDao account_dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Account> getAll() {
		
		return (List<Account>) account_dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Account get(Long id) {
		return account_dao.findById(id).orElse(null);
		//return account_dao.findById(id).get();
	}

	@Override
	@Transactional
	public Account save(Account account) {
		return account_dao.save(account);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		account_dao.deleteById(id);	
	}	
	
	
}
