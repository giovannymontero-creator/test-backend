package com.nuvu.testbacked.models.services;

import java.util.List;

import com.nuvu.testbacked.models.entity.CreditCard;

/*------------------------------------------------------------
Descripción: Esta interface define los metodos para que puedan ser implementados por la clase de servicios de la tarjeta de credito
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la interface					   
*/
public interface ICreditCardService {

	public CreditCard get(Long id);

	public List<CreditCard> getAll();

	public CreditCard save(CreditCard creditCard);

	public void delete(Long id);
}
