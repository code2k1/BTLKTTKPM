package com.kttkpm.customer.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kttkpm.customer.model.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId>{

	@Query("{customerId : ?0}")
	Customer getCustomerById(ObjectId customerId);
	
	@Query("{$and:[{phoneNumber: ?0},{password: ?1}]}")
	Customer getCustomerByPhoneAndPassword(String phoneNumber, String password);
}
