package com.kttkpm.product.dtos;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeResponse {
	private ObjectId productTypeId;
	private String productTypeName;
}
