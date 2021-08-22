package com.getir.readingisgood.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.data.CustomerRepository;
import com.getir.readingisgood.data.OrderRepository;
import com.getir.readingisgood.modal.Customer;
import com.getir.readingisgood.modal.Order;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	public Customer registerCustomer(Customer customer) {
		customer.setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
		return customerRepository.save(customer);
	}

	@Override
	public List<Order> allOrders(Customer customer, Pageable pageable) {
		return orderRepository.findByCustomer(customer, pageable);
	}
	
	@Override
	public Customer findById(long id) {
		return customerRepository.findById(id).get();
	}
}
