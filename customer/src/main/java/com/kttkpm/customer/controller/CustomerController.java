package com.kttkpm.customer.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kttkpm.customer.model.Customer;
import com.kttkpm.customer.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping()
	public List<Customer> getCustomers() {
		return service.getCustomers();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable ObjectId customerId) {
		return service.getCustomerById(customerId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}

	@GetMapping("/customer/{phoneNumber}/{password}")
	public Customer getCustomerById(@PathVariable String phoneNumber, @PathVariable String password) {
		return service.getCustomerByPhoneAndPassword(phoneNumber, password);
	}

	@PutMapping
	public Customer udateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}

}
