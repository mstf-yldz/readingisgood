package com.getir.readingisgood.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.getir.readingisgood.modal.Customer;
import com.getir.readingisgood.modal.Order;

public interface ICustomerService {
	public Customer registerCustomer(Customer customer);
	public List<Order> allOrders(Customer customer, Pageable pageable);
	Customer findById(long id);

}
