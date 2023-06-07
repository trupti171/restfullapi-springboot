package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Customer;
import com.example.demo.response.ResponseStructure;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
@Autowired
private CustomerService customerService;

@PostMapping(path="/persist")

    public ResponseEntity<?> insertCustomer(@RequestBody Customer customer){
	
	ResponseStructure<?> responseStructure=customerService.insertCustomer( customer);
	return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
}

@GetMapping(path="/fetch")
	public ResponseEntity<?> findAllCustomers(){
	
	ResponseStructure<?> responseStructure=customerService.findAllCustomers();
	return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
}

@GetMapping(path="fetch/{custId}")
    public ResponseEntity<?> findCustById(@PathVariable Integer custId){
	ResponseStructure<?> responseStructure=customerService.findCustById( custId);
	return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
}

@DeleteMapping(path="/delete/{custId}")
public ResponseEntity<?> deleteCustomer(@PathVariable Integer custId){
	ResponseStructure<?> responseStructure=customerService.deleteCustomer(custId);
	return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
}

}
