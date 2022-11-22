package com.kttkpm.product_type.services;
import java.util.List;

import org.bson.types.ObjectId;

import com.kttkpm.product_type.model.ProductType;
public interface ProductTypeService {
	ProductType createProductType(ProductType productType);
	List<ProductType> getAllProductType();
	ProductType findByProductTypeId(ObjectId productTypeId);
	ProductType getProductTypeByName(String productTypeName);
	ProductType updateProductType(ProductType productType);
}
