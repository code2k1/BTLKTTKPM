package com.kttkpm.product.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.kttkpm.product.dtos.ProductResponse;
import com.kttkpm.product.dtos.ProductTypeResponse;
import com.kttkpm.product.model.Product;

public interface ProductService {
	Product findByProductId(ObjectId productId);
	ProductResponse getProductContainTypeProductByIdProduct(ObjectId productId);
	Product createProduct(Product product);
	List<Product> getAllProduct();
	Product updateProduct(Product product);
	List<Product> getProductByProductTypeId(ObjectId productTypeId);
	ProductTypeResponse getProductTypeByProductId(ObjectId productId);
}
