package com.sathya.springmvc.test;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springmvc.entity.ProductEntity;
import com.sathya.springmvc.productModel.ProductModel;
import com.sathya.springmvc.service.Productservice;

import jakarta.validation.Valid;

@Controller
public class Testcontroller {
	@Autowired
	Productservice productservice;
	@GetMapping("/Productform")	
	public String getProduct(Model model)
	{
		ProductModel productModel= new ProductModel();
		productModel.setMadeIn("India");
		productModel.setQuantity(2);
		productModel.setDiscountRate(10.5);
		
		model.addAttribute("productModel", productModel);
		return "add-product";
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@Valid ProductModel productModel,BindingResult bindingResult, Model model)
	{
		HashMap<String, String> validationErrors=new HashMap<String, String>();
		if(bindingResult.hasErrors())
		{
			for(FieldError fieldError:bindingResult.getFieldErrors())
			{
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			model.addAttribute("validationErrors", validationErrors);
			return "add-product";
		}
						
		    productservice.saveProductDetails(productModel);
		      return "redirect:/getallproducts";
	}
	@GetMapping("/getallproducts")
	public String getAllProducts(Model model)
	{
		List<ProductEntity> products= productservice.getAllProducts();
		model.addAttribute("products", products);
		return "product-list";
	}
	//Search Product by id
	@GetMapping("/getsearchform")
	public String getsearchForm()
	{
		return "searchform";
	}
	@PostMapping("/searchbyid")
	public String searchById(@RequestParam Long id,Model model)
  	{
		ProductEntity product = productservice.searchById(id);
		model.addAttribute("product", product);
		return "searchform";
  	}
	//delete operation
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable Long id)
	{
		productservice.deleteProductById(id);
		return "redirect:/getallproducts";
	}
	@GetMapping("/edit/{id}")
	public String getEditForm(@PathVariable Long id, Model model) {
	    ProductEntity product = productservice.searchById(id);  
	    model.addAttribute("product", product);  
	    model.addAttribute("id", id);
	    return "updateform";  
	}
	@PostMapping("/editproductsave/{id}")
	public String updateProduct(@PathVariable Long id,ProductModel productModel) {
	    productservice.updateProduct(productModel, id);  
	    return "redirect:/getallproducts";  
	}
}