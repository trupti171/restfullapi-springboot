package com.example.demo.repository;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Customer;
import com.example.demo.exception.CustomerIdNotFoundException;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	//simpleJPArepository object
	//CRUD operation method impl
	public Customer insertCustomer(Customer customer) {
		return customerRepository.save(customer);//persistence logic
	}
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll() ;
	}
    
	
//	public Optional<Customer> findCustById(Integer custId) {
//		Optional<Customer> findById=customerRepository.findById(custId);
//		return findById;
//	}
	
	public Customer findCustById(Integer custId) {
		Optional<Customer> findById=customerRepository.findById(custId);
		if(findById.isPresent()) {
			customerRepository.findById(custId);
			return findById.get();
		}
		throw new CustomerIdNotFoundException("user id not found");

	}
	 
	public Customer  deleteCustomer(Integer custId) {
		Optional<Customer> findById=customerRepository.findById(custId);
		if(findById.isPresent()) {
			customerRepository.deleteById(custId);
			return findById.get();
		}
		throw new CustomerIdNotFoundException("user id not found");
	}
 
}
