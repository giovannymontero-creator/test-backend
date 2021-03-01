package com.nuvu.testbacked.models.services;

import java.util.List;

import com.nuvu.testbacked.models.entity.Customer;

/*------------------------------------------------------------
Descripción: Esta interface define los metodos para que puedan ser implementados por la clase de servicios del cliente
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la interface					   
*/
public interface ICustomerService {

	public Customer get(String id);

	public List<Customer> getAll();

	public Customer save(Customer customer);

	public void delete(String id);
}
