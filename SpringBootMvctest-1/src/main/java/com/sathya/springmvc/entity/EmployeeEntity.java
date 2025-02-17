package com.sathya.springmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
   @Id
   private long id;
   private String name;
   private double salary;
   private int age;
   private String gender;
   private String department;
   private String experience;
   private double da;
   private double hra;
   private double pf;
   private double bonus;
   private double grossSalary;
   private double totalSalary;
 
}
