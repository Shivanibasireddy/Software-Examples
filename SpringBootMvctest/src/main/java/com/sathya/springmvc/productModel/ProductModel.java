package com.sathya.springmvc.productModel;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	@NotBlank(message="Product name can't be blank")
	private String name;
	
	@NotBlank(message="MadeIn name can't be blank")
	private String madeIn;
	
	@Positive(message="Price must be greater than zero")
	private double price;
	
	@NotBlank(message="Brand name can't be blank")
	private String brand;
	
	@Min(value = 1, message="Quantity must be atleast 1 ")
	private int quantity;
	
	@DecimalMax(value = "100.0",message="DiscountRate can't exceed 100")
	private double discountRate;
	
	@DecimalMax(value = "40.0",message="TaxPrice can't exceed 100")
	private double taxPrice;
	 
	 

}
