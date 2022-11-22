package com.kttkpm.product.controller;

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

import com.kttkpm.product.dtos.ProductResponse;
import com.kttkpm.product.dtos.ProductTypeResponse;
import com.kttkpm.product.model.Product;
import com.kttkpm.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}
	@GetMapping
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable  ObjectId productId) {
		return service.findByProductId(productId);
	}
	
	@GetMapping("/product_full_value/{productId}")
    public ProductResponse getProductContainTypeProductByIdProduct(@PathVariable ObjectId productId) {
        return service.getProductContainTypeProductByIdProduct(productId);
    }
	
	
	@GetMapping("/productByProductTypeID/{productTypeId}")
    public List<Product> getProductByProductTypeId(@PathVariable ObjectId productTypeId) {
        return service.getProductByProductTypeId(productTypeId);
    }
	
	@GetMapping("/productTypeByProductID/{productId}")
    public  ProductTypeResponse getProductTypeByProductTypeId(@PathVariable ObjectId productId) {
        return service.getProductTypeByProductId(productId);
    }
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
			return service.updateProduct(product);
	}
}
