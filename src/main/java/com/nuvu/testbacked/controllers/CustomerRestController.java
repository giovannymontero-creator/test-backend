package com.nuvu.testbacked.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nuvu.testbacked.models.entity.Account;
import com.nuvu.testbacked.models.entity.CreditCard;
import com.nuvu.testbacked.models.entity.Customer;
import com.nuvu.testbacked.models.services.IAccountService;
import com.nuvu.testbacked.models.services.ICreditCardService;
import com.nuvu.testbacked.models.services.ICustomerService;

/*------------------------------------------------------------
Descripción: Este controlador REST se crea para recibir las peticiones GET, POST, PUT y DELETE 
para los endpoints de clientes, cuentas y tarjetas de credito. 
 
Fecha         Autor                            Descripción
----------    ------------------------------   ----------------------------------
25/02/2021    Giovanny Montero Beltrán         Creación de clase controlador					   
*/
@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private ICustomerService customer_service;

	@Autowired
	private IAccountService account_service;

	@Autowired
	private ICreditCardService credit_card_service;

	@GetMapping("/customers")
	public List<Customer> index() {
		return customer_service.getAll();
	}

	@GetMapping("/customers/{id}")
	public Customer show(@PathVariable String id) {
		return customer_service.get(id);
	}

	@PostMapping("/customers")
	@ResponseStatus(HttpStatus.CREATED) // 201
	public Customer create(@RequestBody Customer customer) {
		return customer_service.save(customer);
	}

	@PutMapping("/customers/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer update(@RequestBody Customer customer, @PathVariable String id) {
		Customer customer_current = customer_service.get(id);

		customer_current.setName(customer.getName());
		customer_current.setLast_name(customer.getLast_name());
		customer_current.setIdentification_type(customer.getIdentification_type());
		customer_current.setEmail(customer.getEmail());
		customer_current.setCell_phone_number(customer.getCell_phone_number());
		customer_current.setAddress(customer.getAddress());

		return customer_service.save(customer_current);
	}

	@DeleteMapping("/customers/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void delete(@PathVariable String id) {
		customer_service.delete(id);
	}

	@GetMapping("/accounts")
	public List<Account> accountAll() {
		return account_service.getAll();
	}

	@GetMapping("/accounts/{id}")
	public Account showAccountById(@PathVariable Long id) {
		return account_service.get(id);
	}

	@PostMapping("/accounts")
	@ResponseStatus(HttpStatus.CREATED) // 201
	public Account createAccount(@RequestBody Account account) {
		return account_service.save(account);
	}

	@PutMapping("/accounts/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Account updateAccount(@RequestBody Account account, @PathVariable Long id) {
		Account account_current = account_service.get(id);

		account_current.setStatus(account.getStatus());

		return account_service.save(account_current);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void deleteAccount(@PathVariable Long id) {
		account_service.delete(id);
	}

	@GetMapping("/credit_cards")
	public List<CreditCard> creditCardAll() {
		return credit_card_service.getAll();
	}

	@GetMapping("/credit_cards/{id}")
	public CreditCard showCreditCardById(@PathVariable Long id) {
		return credit_card_service.get(id);
	}

	@PostMapping("/credit_cards")
	@ResponseStatus(HttpStatus.CREATED) // 201
	public CreditCard createCreditCard(@RequestBody CreditCard creditCard) {
		return credit_card_service.save(creditCard);
	}

	@PutMapping("/credit_cards/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CreditCard updateCreditCard(@RequestBody CreditCard creditCard, @PathVariable Long id) {
		CreditCard credit_card_current = credit_card_service.get(id);

		credit_card_current.setCvv(creditCard.getCvv());
		credit_card_current.setStatus(creditCard.getStatus());

		return credit_card_service.save(credit_card_current);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void deleteCreditCard(@PathVariable Long id) {
		credit_card_service.delete(id);
	}
}
