package com.kttkpm.product_type.repositorys;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

import com.kttkpm.product_type.model.ProductType;

@Repository
public interface ProductTypeRepository extends MongoRepository<ProductType, Long>{

	@Query("{productTypeName: ?0 }")
	ProductType findByProductTypeName(String productTypeName);

	@Query("{productTypeId: ?0 }")
	ProductType findByProductTypeId(ObjectId productTypeId);

}
