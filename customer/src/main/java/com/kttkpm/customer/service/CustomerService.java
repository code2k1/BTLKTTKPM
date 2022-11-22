package com.kttkpm.customer.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.kttkpm.customer.model.Customer;

public interface CustomerService {
	public Customer getCustomerByPhoneAndPassword(String phoneNumber, String password);

	public Customer getCustomerById(ObjectId customerId);

	public List<Customer> getCustomers();

	public Customer updateCustomer(Customer customer);

	public Customer saveCustomer(Customer customer);
}
