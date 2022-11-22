package com.kttkpm.billdetail.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private ObjectId productId;
	private String productName;
	private Double price;
	private int amount;
	private LocalDate exDate ;
	private String image;
	private ObjectId productTypeId;
}
