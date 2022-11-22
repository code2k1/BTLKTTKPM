package com.kttkpm.product.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kttkpm.product.model.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId>{
	@Query("{productId: ?0 }")
	Product findByProductId(ObjectId productId);

	@Query("{productTypeId: ?0 }")
	List<Product> getProductByProductTypeId(ObjectId productTypeId);

}
