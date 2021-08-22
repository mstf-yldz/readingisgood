package com.getir.readingisgood.services;

import java.time.LocalDateTime;
import java.util.List;

import com.getir.readingisgood.modal.Order;

public interface IOrderService {

	public Order placeOrder(Order order);
	public void setBooksIsInOrderProcess(Order order);
	public void setBooksIsNotInOrderProcess(Order order);
	public Order findById(long id);
	public List<Order> findByOrderDateBetween(LocalDateTime from, LocalDateTime to);
}
