package com.kttkpm.bill.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kttkpm.bill.model.Bill;
@Repository
public interface BillRepository extends MongoRepository<Bill, ObjectId>{

	@Query("{billId : ?0}")
	Bill getBillById(ObjectId billId);

	@Query("{customerId : ?0}")
	List<Bill> getBillByCustomerId(ObjectId customerId);
}
