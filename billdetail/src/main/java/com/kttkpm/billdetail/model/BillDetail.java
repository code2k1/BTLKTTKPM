package com.kttkpm.billdetail.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bill_details")
public class BillDetail {
	@Id
	private ObjectId billDetailId;
	private double totalPrice;
	private int amount;
	private ObjectId productId;
	private ObjectId billId;
}
