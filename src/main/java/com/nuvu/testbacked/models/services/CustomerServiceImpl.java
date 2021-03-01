package com.nuvu.testbacked.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuvu.testbacked.models.dao.ICustomerDao ;
import com.nuvu.testbacked.models.entity.Customer;

/*------------------------------------------------------------
Descripción: Esta clase implementa la interface de servicios para configurar los metodos del CRUD
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de la clase de servicios para el cliente					   
*/
@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerDao customer_dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> getAll() {
		
		return (List<Customer>) customer_dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer get(String id) {
		return customer_dao.findById(id).orElse(null);
		//return customer_dao.findById(id).get();
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {
		return customer_dao.save(customer);
	}

	@Override
	@Transactional
	public void delete(String id) {
		customer_dao.deleteById(id);	
	}	
	
	
}
