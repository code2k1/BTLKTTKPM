package com.kttkpm.customer.model;

import java.time.LocalDate;
import java.util.Calendar;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
	@Id
	private ObjectId customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	private LocalDate dateOfBirth = LocalDate.of(2001, Calendar.DECEMBER+ 1, 9);
	private int cancelAnOrderCount=0;
	private String password;
}
