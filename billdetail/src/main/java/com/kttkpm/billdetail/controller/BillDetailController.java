package com.kttkpm.billdetail.controller;

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

import com.kttkpm.billdetail.model.BillDetail;
import com.kttkpm.billdetail.service.BillDetailService;

@RestController
@RequestMapping("/billDetails")
public class BillDetailController {
	@Autowired
	private BillDetailService service;

	@GetMapping()
	public List<BillDetail> getBillDetails() {
		return service.getBillDetails();
	}

	@GetMapping("/{billDetailId}")
	public BillDetail getBillDetailById(@PathVariable ObjectId billDetailId) {
		return service.getBillDetailById(billDetailId);
	}

	@GetMapping("/listBillDetail/billId/{billId}")
	public List<BillDetail> getBillDetailByBillId(@PathVariable ObjectId billId) {
		return service.getBillDetailByBillId(billId);
	}

	@GetMapping("/listBillDetail/productId/{productId}")
	public List<BillDetail> getBillDetailByProductId(@PathVariable ObjectId productId) {
		return service.getBillDetailByProductId(productId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public BillDetail saveBillDetail(@RequestBody BillDetail billDetail) {
		return service.saveBillDetail(billDetail);
	}

	@PutMapping
	public BillDetail udateBill(@RequestBody BillDetail billDetail) {
		return service.updateBillDetail(billDetail);
	}

}
