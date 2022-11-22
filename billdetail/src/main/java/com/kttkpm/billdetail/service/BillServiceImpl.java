package com.kttkpm.billdetail.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kttkpm.billdetail.Repository.BillDetailRepository;
import com.kttkpm.billdetail.model.Bill;
import com.kttkpm.billdetail.model.BillDetail;
import com.kttkpm.billdetail.model.Product;

@Service
public class BillServiceImpl implements BillDetailService {

	@Autowired
	private BillDetailRepository billDetailRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public BillDetail getBillDetailById(ObjectId billDetailId) {
		return billDetailRepository.getBillDetailById(billDetailId);
	}

	@Override
	public List<BillDetail> getBillDetails() {
		// TODO Auto-generated method stub
		return billDetailRepository.findAll();
	}

	@Override
	public List<BillDetail> getBillDetailByBillId(ObjectId billId) {
		return billDetailRepository.getBillDetailByBillId(billId);
	}

	@Override
	public List<BillDetail> getBillDetailByProductId(ObjectId productId) {
		return billDetailRepository.getBillDetailByProductId(productId);
	}

	@Override
	public BillDetail updateBillDetail(BillDetail billDetail) {
		BillDetail billDetail1 = billDetailRepository.getBillDetailById(billDetail.getBillDetailId());
		String uri = "http://BILL-SERVICE/bills/" + billDetail.getBillId();
		String uriProduct = "http://PRODUCT-SERVICE/products/" + billDetail.getProductId();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		if (billDetail1.getTotalPrice() > billDetail.getTotalPrice()) {
			Bill bill = restTemplate.getForObject(uri, Bill.class);
			bill.setTotalPrice(bill.getTotalPrice() - (billDetail1.getTotalPrice() - billDetail.getTotalPrice()));
			HttpEntity<Bill> httpEntity = new HttpEntity<>(bill, headers);
			restTemplate.put(uri, httpEntity);
		} else {
			Bill bill = restTemplate.getForObject(uri, Bill.class);
			bill.setTotalPrice(bill.getTotalPrice() + (billDetail.getTotalPrice() - billDetail1.getTotalPrice()));
			HttpEntity<Bill> httpEntity = new HttpEntity<>(bill, headers);
			restTemplate.put(uri, httpEntity);
		}

		if (billDetail1.getAmount() > billDetail.getAmount()) {
			Product product = restTemplate.getForObject(uriProduct, Product.class);
			product.setAmount(product.getAmount() + (billDetail1.getAmount() - billDetail.getAmount()));
			HttpEntity<Product> httpEntity = new HttpEntity<>(product, headers);
			restTemplate.put(uri, httpEntity);
		} else {
			Product product = restTemplate.getForObject(uriProduct, Product.class);
			product.setAmount(product.getAmount() - (billDetail.getAmount() - billDetail1.getAmount()));
			HttpEntity<Product> httpEntity = new HttpEntity<>(product, headers);
			restTemplate.put(uri, httpEntity);
		}

		return billDetailRepository.save(billDetail);
	}

	@Override
	public BillDetail saveBillDetail(BillDetail billDetail) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String uri = "http://BILL-SERVICE/bills/" + billDetail.getBillId();
		String uriProduct = "http://PRODUCT-SERVICE/products/" + billDetail.getProductId();
		// Set object request
		Bill bill = restTemplate.getForObject(uri, Bill.class);
		bill.setTotalPrice(bill.getTotalPrice() + billDetail.getTotalPrice());
		HttpEntity<Bill> httpEntity = new HttpEntity<>(bill, headers);
		restTemplate.put("http://BILL-SERVICE/bills/", httpEntity);

		Product product = restTemplate.getForObject(uriProduct, Product.class);
		product.setAmount(product.getAmount() - billDetail.getAmount());
		HttpEntity<Product> httpProduct = new HttpEntity<>(product, headers);
		restTemplate.put("http://PRODUCT-SERVICE/products/", httpProduct);

		return billDetailRepository.save(billDetail);
	}

}
