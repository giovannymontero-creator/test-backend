package com.nuvu.testbacked.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.nuvu.testbacked.models.entity.CreditCard;

/*------------------------------------------------------------
Descripción: Esta interface extiende de la clase CrudRepository para poder tener acceso los metodos del CRUD
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación del DAO	para la tarjeta de credito				   
*/
public interface ICreditCardDao extends CrudRepository<CreditCard, Long>{

}