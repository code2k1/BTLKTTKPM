package com.kttkpm.product_type.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

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
	@TimeLimiter(name = "passenger", fallbackMethod = "fallBackMethod")
	public CompletableFuture<List<ProductType>>  getAllProductType(){
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CompletableFuture.supplyAsync(() ->service.getAllProductType());
	}
	
	public CompletableFuture<String> fallBackMethod(Long passengerId, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong!");
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
