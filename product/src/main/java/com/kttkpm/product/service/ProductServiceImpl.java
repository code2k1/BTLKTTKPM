package com.kttkpm.product.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kttkpm.product.dtos.ProductResponse;
import com.kttkpm.product.dtos.ProductTypeResponse;
import com.kttkpm.product.model.Product;
import com.kttkpm.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findByProductId(ObjectId productId) {
		return productRepository.findByProductId(productId);
	}

	@Override
	public ProductResponse getProductContainTypeProductByIdProduct(ObjectId productId) {
		ProductResponse productResponse = new ProductResponse();

		Product product = productRepository.findByProductId(productId);

		ProductTypeResponse productTypeResponse = restTemplate.getForObject(
				"http://PRODUCT-TYPE-SERVICE/productTypes/" + product.getProductTypeId(), ProductTypeResponse.class);

		productResponse.setProduct(product);
		productResponse.setProductTypeResponse(productTypeResponse);
		return productResponse;
	}
	
	
	
	@Override
	public Product updateProduct(Product product) {
		Product p= productRepository.findByProductId(product.getProductId());
		return  p!=null? productRepository.save(product):null;
	}
	@Override
	public List<Product> getProductByProductTypeId(ObjectId productTypeId) {
		return  productRepository.getProductByProductTypeId(productTypeId);
	}
	@Override
	public ProductTypeResponse getProductTypeByProductId(ObjectId productId) {
		Product product = productRepository.findByProductId(productId);

		ProductTypeResponse productTypeResponse = restTemplate.getForObject(
				"http://PRODUCT-TYPE-SERVICE/productTypes/" + product.getProductTypeId(), ProductTypeResponse.class);
		return  productTypeResponse;
	}
}
