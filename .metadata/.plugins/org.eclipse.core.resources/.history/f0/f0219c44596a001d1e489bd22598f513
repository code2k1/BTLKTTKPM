package com.kttkpm.billdetail.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kttkpm.billdetail.model.BillDetail;

@Repository
public interface BillDetailRepository extends MongoRepository<BillDetail, ObjectId> {

	@Query("{billDetailId : ?0}")
	BillDetail getBillDetailById(ObjectId billDetailId);

	@Query("{billId : ?0}")
	List<BillDetail> getBillDetailByBillId(ObjectId billId);

	@Query("{productId : ?0}")
	List<BillDetail> getBillDetailByProductId(ObjectId productId);

//	@Query("{billId : ?0}")
//	Bill getBillById(ObjectId billId);
//
//	@Query("{customerId : ?0}")
//	List<Bill> getBillByCustomerId(ObjectId customerId);
}
