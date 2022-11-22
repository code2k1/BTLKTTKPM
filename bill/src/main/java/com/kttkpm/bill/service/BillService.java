package com.kttkpm.bill.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.kttkpm.bill.model.Bill;
import com.kttkpm.bill.model.Customer;

public interface BillService {
	public Bill getBillById(ObjectId billId);
	public List<Bill> getBills();
	public List<Bill> getBillByCustomerId(ObjectId customerId);
	public Bill updateBill(Bill bill);
	public Bill saveBill(Bill bill);
	Customer getCustomerByBillId(ObjectId billId);
}
