package com.kttkpm.product_type.controller;

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

import com.kttkpm.product_type.model.ProductType;
import com.kttkpm.product_type.services.ProductTypeService;

@RestController
@RequestMapping("/productTypes")
public class ProductTypeController {
	@Autowired
	private ProductTypeService service;
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ProductType createProductType(@RequestBody ProductType productType) {
		return service.createProductType(productType);
	}
	@GetMapping
	public List<ProductType> getAllProductType(){
		return service.getAllProductType();
	}
	
	@GetMapping("/{productTypeId}")
	public ProductType getProductTypeById(@PathVariable  ObjectId productTypeId) {
		return service.findByProductTypeId(productTypeId);
	}
	
	@GetMapping("/productTypeName/{productTypeName}")
	public ProductType getProductTypeByName(@PathVariable  String productTypeName) {
		return service.getProductTypeByName(productTypeName);
	}
	
	@PutMapping()
	public ProductType updateProductType(@RequestBody ProductType productType) {
		return service.updateProductType(productType);
	}
	
}
