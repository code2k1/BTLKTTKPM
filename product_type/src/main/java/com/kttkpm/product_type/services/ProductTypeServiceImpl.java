package com.kttkpm.product_type.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kttkpm.product_type.model.ProductType;
import com.kttkpm.product_type.repositorys.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public ProductType createProductType(ProductType productType) {
		return productTypeRepository.save(productType);
	}

	@Override
	public List<ProductType> getAllProductType() {
		// TODO Auto-generated method stub
		return productTypeRepository.findAll();
	}

	@Override
	public ProductType findByProductTypeId(ObjectId productTypeId) {
		// TODO Auto-generated method stub
		return productTypeRepository.findByProductTypeId(productTypeId);
	}

	@Override
	public ProductType getProductTypeByName(String productTypeName) {
		// TODO Auto-generated method stub
		return productTypeRepository.findByProductTypeName(productTypeName);
	}


	@Override
	public ProductType updateProductType(ProductType productType) {
		// TODO Auto-generated method stub
		ProductType pt=productTypeRepository.findByProductTypeId(productType.getProductTypeId());
		pt.setProductTypeName(productType.getProductTypeName());
		return productTypeRepository.save(pt);
		
	}

}
