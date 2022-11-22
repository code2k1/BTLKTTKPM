package com.kttkpm.customer.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kttkpm.customer.Repository.CustomerRepository;
import com.kttkpm.customer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(ObjectId customerId) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public Customer getCustomerByPhoneAndPassword(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerByPhoneAndPassword(phoneNumber, password);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer c = customerRepository.getCustomerById(customer.getCustomerId());
		return c != null ? customerRepository.save(customer) : null;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

}
