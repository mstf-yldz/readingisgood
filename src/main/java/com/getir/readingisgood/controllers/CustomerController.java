package com.getir.readingisgood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.exception.CustomerNotFoundException;
import com.getir.readingisgood.modal.Customer;
import com.getir.readingisgood.modal.Order;
import com.getir.readingisgood.services.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping(path="/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.registerCustomer(customer), HttpStatus.CREATED) ;	
	}
	
	@GetMapping(path="/orders/{id}/{size}/{index}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Order>> allOrders(@PathVariable long id, @PathVariable int size, @PathVariable int index){
		Pageable pageable = PageRequest.of(index, size);
		Customer customer = customerService.findById(id);
		if(customer == null) throw new CustomerNotFoundException("Customer not found!");
		return new ResponseEntity<List<Order>>(customerService.allOrders(customer, pageable), HttpStatus.OK);
	}
}
