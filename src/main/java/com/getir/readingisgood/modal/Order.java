package com.getir.readingisgood.modal;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
	
	public static final String SEQUENCE_NAME = "order_sequence";

	@Id
	private long id;
	
	@DBRef
	private Customer customer;
	@NotNull
	private LocalDateTime orderDate;
	@NotEmpty
	private Collection<OrderBookCount> orderBooks;
	@NotNull
	@Min(1)
	private double totalAmount;
	
	public Order() {}

	public Order(Customer customer, LocalDateTime orderDate, Collection<OrderBookCount> orderBooks, double totalAmount) {
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderBooks = orderBooks;
		this.totalAmount = totalAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Collection<OrderBookCount> getOrderBooks() {
		return orderBooks;
	}

	public void setOrderBooks(Collection<OrderBookCount> orderBooks) {
		this.orderBooks = orderBooks;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	// TODO toString override
}
