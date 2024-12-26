package com.sathya.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sathya.springmvc.entity.ProductEntity;
import com.sathya.springmvc.productModel.ProductModel;
import com.sathya.springmvc.repository.ProductRepository;

@Service
public class Productservice {
      @Autowired
      ProductRepository productRepository;
      public void saveProductDetails(ProductModel productModel)
	  { 
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
		
		
		double offerPrice;
		offerPrice=productModel.getPrice()-discountPrice;
		
	
		double finalPrice;
		finalPrice=productModel.getTaxPrice()+offerPrice;
		
		
		double stockValue;
		stockValue = productModel.getPrice() * productModel.getQuantity();
		
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountRate(productModel.getDiscountRate());
		productEntity.setTaxPrice(productModel.getTaxPrice());
		productEntity.setDiscountPrice(discountPrice);
		productEntity.setFinalPrice(finalPrice);
		productEntity.setStockValue(stockValue);
		productEntity.setOfferPrice(offerPrice);
		
		productRepository.save(productEntity);
		
	}
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> products= productRepository.findAll();
		return products;
	}
	public ProductEntity searchById(Long id)
	{
		Optional<ProductEntity> optionalData= productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product= optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
	public void editProductsave(ProductModel productModel)
	{ 
	  ProductEntity products = new ProductEntity();
	  products.setName(productModel.getName());
	  products.setMadeIn(productModel.getMadeIn());
	  products.setPrice(productModel.getPrice());
	  products.setBrand(productModel.getBrand());
	  products.setQuantity(productModel.getQuantity());
	  products.setDiscountRate(productModel.getDiscountRate());
	  products.setTaxPrice(productModel.getTaxPrice());
   }
	
	
	public void updateProduct(ProductModel productModel, Long id) {
		Optional<ProductEntity> optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity entity=optionalData.get();
			entity.setName(productModel.getName());
			entity.setMadeIn(productModel.getMadeIn());
			entity.setPrice(productModel.getPrice());
			entity.setBrand(productModel.getBrand());
			entity.setQuantity(productModel.getQuantity());
			entity.setDiscountRate(productModel.getDiscountRate());
			entity.setTaxPrice(productModel.getTaxPrice());
			
			double discountPrice;
			discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
			
			
			double offerPrice;
			offerPrice=productModel.getPrice()-discountPrice;
			
		
			double finalPrice;
			finalPrice=productModel.getTaxPrice()+offerPrice;
			
			
			double stockValue;
			stockValue = productModel.getPrice() * productModel.getQuantity();
			
			entity.setDiscountPrice(discountPrice);
			entity.setOfferPrice(offerPrice);
			entity.setFinalPrice(finalPrice);
			entity.setStockValue(stockValue);
			
			productRepository.save(entity);
			
			
		}
		
	}
	
	
	
	 
	
}

