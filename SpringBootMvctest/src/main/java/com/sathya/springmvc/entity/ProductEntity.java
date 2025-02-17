package com.sathya.springmvc.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String madeIn;
	private double price;
	private String brand;
	private int quantity;
	private double taxPrice;
	private double discountRate;
	private double discountPrice;
	private double offerPrice;
    private double stockValue;
	private double finalPrice;
}
