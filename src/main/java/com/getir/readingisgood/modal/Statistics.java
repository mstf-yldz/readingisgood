package com.getir.readingisgood.modal;

import org.springframework.data.annotation.Id;

public class Statistics {
	public static final String SEQUENCE_NAME = "statistics_sequence";
	@Id
	private long id;
	private long totalOrderCount;
	private float totalPurchasedOrderAmount;
	private long totalCountOfPurchasedBooks;
	
	public Statistics() {}

	public long getTotalOrderCount() {
		return totalOrderCount;
	}

	public void setTotalOrderCount(long totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}

	public float getTotalPurchasedOrderAmount() {
		return totalPurchasedOrderAmount;
	}

	public void setTotalPurchasedOrderAmount(float totalPurchasedOrderAmount) {
		this.totalPurchasedOrderAmount = totalPurchasedOrderAmount;
	}

	public long getTotalCountOfPurchasedBooks() {
		return totalCountOfPurchasedBooks;
	}

	public void setTotalCountOfPurchasedBooks(long totalCountOfPurchasedBooks) {
		this.totalCountOfPurchasedBooks = totalCountOfPurchasedBooks;
	}
	
}
