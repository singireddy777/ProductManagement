package com.hcl.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.entity.Product;
import com.hcl.product.entity.ProductCount;
import com.hcl.product.repository.ProductCountRepository;
import com.hcl.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired ProductRepository productRepo;
	@Autowired ProductCountRepository productCountRepo;
	public List<Product> productList() {
		return productRepo.findAll();
		
	}

	@Override
	public Product getProductByProdId(int productId) {
		int userId = 1;
		
		Product product = productRepo.findById(productId).get();
		
		
		ProductCount productCount = productCountRepo.getProductCountByProdIdandUserId(product.getProductId(), userId);
		
		if(productCount !=null) {
			productCount.setProductCount(productCount.getProductCount()+1);
			productCountRepo.save(productCount);
		}else {
		
			ProductCount productCount1 = new ProductCount();
		productCount1.setProductCount(1);
		productCount1.setProdInterested("interested");
		productCount1.setUserId(1);
		productCount1.setProdId(productId);
		productCountRepo.save(productCount1);
			
		}
		return product;
		}

	@Override
	public List<?> getAnalyticsProdInterested(int productId) {

		return productCountRepo.getProductCountByProdId(productId);
	}	
	
}
