package com.kttkpm.bill.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kttkpm.bill.Repository.BillRepository;
import com.kttkpm.bill.model.Bill;
import com.kttkpm.bill.model.Customer;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Bill getBillById(ObjectId billId) {
		// TODO Auto-generated method stub
		return billRepository.getBillById(billId);
	}

	@Override
	public Bill saveBill(Bill bill) {
		// TODO Auto-generated method stub
		return billRepository.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill) {
		Bill b = billRepository.getBillById(bill.getBillId());
		return b != null ? billRepository.save(bill) : null;
	}

	@Override
	public List<Bill> getBillByCustomerId(ObjectId customerId) {
		return billRepository.getBillByCustomerId(customerId);
	}

	@Override
	public Customer getCustomerByBillId(ObjectId billId) {

		Bill bill = billRepository.getBillById(billId);

		Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customers/" + bill.getCustomerId(),
				Customer.class);

		return customer;
	}

	@Override
	public List<Bill> getBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

}
