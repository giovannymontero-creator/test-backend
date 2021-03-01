package com.nuvu.testbacked.models.services;

import java.util.List;

import com.nuvu.testbacked.models.entity.Account;

/*------------------------------------------------------------
Descripción: Esta interface define los metodos para que puedan ser implementados por la clase de servicios de la cuenta bancaria
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la interface					   
*/
public interface IAccountService {
	
	public Account get(Long id);

	public List<Account> getAll();

	public Account save(Account account);

	public void delete(Long id);
}
