package com.kttkpm.bill.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private ObjectId customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	private LocalDate dateOfBirth;
	private int cancelAnOrderCount=0;
	private String password;
	
}
