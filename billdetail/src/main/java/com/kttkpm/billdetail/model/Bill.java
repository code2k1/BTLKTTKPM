package com.kttkpm.billdetail.model;

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
@Document(collection = "bills")
public class Bill {
	@Id
	private ObjectId billId;
	private LocalDate DayOfCreate;
	private double totalPrice;
	private ObjectId customerId;
}
