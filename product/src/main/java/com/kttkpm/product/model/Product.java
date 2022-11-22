package com.kttkpm.product.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
	@Id
	private ObjectId productId;
	private String productName;
	private Double price;
	private int amount;
	private LocalDate exDate = LocalDate.now();
	private String image;
	private ObjectId productTypeId;
}
