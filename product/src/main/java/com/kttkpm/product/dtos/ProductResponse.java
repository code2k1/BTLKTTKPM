package com.kttkpm.product.dtos;

import com.kttkpm.product.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	private Product product;
	private ProductTypeResponse productTypeResponse;
}
