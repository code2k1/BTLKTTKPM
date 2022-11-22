package com.kttkpm.billdetail.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.kttkpm.billdetail.model.BillDetail;

public interface BillDetailService {
	public BillDetail getBillDetailById(ObjectId billDetailId);
	public List<BillDetail> getBillDetails();
	public List<BillDetail> getBillDetailByBillId(ObjectId billId);
	public List<BillDetail> getBillDetailByProductId(ObjectId productId);
	public BillDetail updateBillDetail(BillDetail billDetail);
	public BillDetail saveBillDetail(BillDetail billDetail);
}
