package com.kttkpm.bill.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kttkpm.bill.model.Bill;
import com.kttkpm.bill.model.Customer;
import com.kttkpm.bill.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {
	@Autowired
	private BillService service;

	@GetMapping("/{billId}")
	public Bill getBillById(@PathVariable ObjectId billId) {
		return service.getBillById(billId);
	}

	@GetMapping()
	public List<Bill> getBills() {
		return service.getBills();
	}

	@GetMapping("/customer/{billId}")
	public Customer getCustomerByBillId(@PathVariable ObjectId billId) {
		return service.getCustomerByBillId(billId);
	}

	@GetMapping("/listBill/{customerId}")
	public List<Bill> getBillsByCustomerId(@PathVariable ObjectId customerId) {
		return service.getBillByCustomerId(customerId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Bill saveBill(@RequestBody Bill bill) {
		return service.saveBill(bill);
	}

	@PutMapping
	public Bill udateBill(@RequestBody Bill bill) {
		return service.updateBill(bill);
	}

}
