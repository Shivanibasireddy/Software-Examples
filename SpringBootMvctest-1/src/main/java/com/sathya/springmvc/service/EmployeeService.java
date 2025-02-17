package com.sathya.springmvc.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springmvc.employeemodel.EmployeeModel;
import com.sathya.springmvc.entity.EmployeeEntity;
import com.sathya.springmvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void saveEmployeeDetails(EmployeeModel  employeeModel)
	{
		double grossSalary;
		grossSalary=employeeModel.getSalary()+employeeModel.getHra()+employeeModel.getBonus();
		
		double totalSalary;
		totalSalary=grossSalary-employeeModel.getPf();
		
		EmployeeEntity employeeEntity= new EmployeeEntity();
		employeeEntity.setId(employeeModel.getId());
		employeeEntity.setName(employeeModel.getName());
		employeeEntity.setSalary(employeeModel.getSalary());
		employeeEntity.setAge(employeeModel.getAge());
		employeeEntity.setGender(employeeModel.getGender());
		employeeEntity.setDepartment(employeeModel.getDepartment());
		employeeEntity.setExperience(employeeModel.getExperience());
		employeeEntity.setDa(employeeModel.getDa());
		employeeEntity.setHra(employeeModel.getHra());
		employeeEntity.setPf(employeeModel.getPf());
		employeeEntity.setBonus(employeeModel.getBonus());
		employeeEntity.setGrossSalary(grossSalary);
		employeeEntity.setTotalSalary(totalSalary);
		
		employeeRepository.save(employeeEntity);
	}
	public List<EmployeeEntity> getAllEmployees()
	{
        List<EmployeeEntity> employees= employeeRepository.findAll();
		return employees;
	}
	public EmployeeEntity searchById(Long id) 
	{
		Optional<EmployeeEntity>  optionalData=employeeRepository.findById(id);  
		if(optionalData.isPresent())
		{
			EmployeeEntity employee=optionalData.get();
			return employee;
		}
		else
		{
			return null;
		}
	}
	
	
	public void deleteEmployeeById(Long id)
	{
		employeeRepository.deleteById(id);
	}
	public void editEmployeeById(Long id) {
	
		
	}
	

}
