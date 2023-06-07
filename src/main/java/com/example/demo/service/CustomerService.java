package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Customer;
import com.example.demo.repository.CustomerDao;
import com.example.demo.response.ResponseStructure;

@Service
public class CustomerService {
@Autowired
private CustomerDao customerDao;

public ResponseStructure<?> insertCustomer(Customer customer) {
	Customer cust=customerDao.insertCustomer(customer);
	
	ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
	responseStructure.setData(cust);
	responseStructure.setHttpstatus(HttpStatus.CREATED);
	return responseStructure;
}

public ResponseStructure<?> findAllCustomers(){
	List<Customer> customerlist=customerDao.findAllCustomers();
	
	ResponseStructure<List<Customer>> responseStructure=new ResponseStructure<>();
	responseStructure.setData(customerlist);
	responseStructure.setHttpstatus(HttpStatus.OK);
	return responseStructure;
}



public ResponseStructure<?> findCustById(Integer custId) {
	
//	Optional<Customer> findCustById=customerDao.findCustById(custId);
//	if(findCustById.isPresent()) {
//		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
//		Customer  customer=findCustById.get();
//		responseStructure.setData(customer);
//		responseStructure.setHttpstatus(HttpStatus.OK);
//		return responseStructure;
//	}
//	else {
//		ResponseStructure<String> responseStructure=new ResponseStructure<>();
//		responseStructure.setData("customer not found");
//		responseStructure.setHttpstatus(HttpStatus.NOT_FOUND);
//		return responseStructure;
//	}
	Customer customer=customerDao.findCustById(custId);
	ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
	responseStructure.setData(customer);
	responseStructure.setHttpstatus(HttpStatus.OK);
	return responseStructure;

	
}
public ResponseStructure<?> deleteCustomer(Integer custId){
	Customer customer=customerDao.deleteCustomer(custId);
	ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
	responseStructure.setData(customer);
	responseStructure.setHttpstatus(HttpStatus.OK);
	return responseStructure;
}
}
