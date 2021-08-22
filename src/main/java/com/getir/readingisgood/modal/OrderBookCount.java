package com.getir.readingisgood.modal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderBookCount {
	@NotNull(message="order book count must be at least 1")
	@Min(1)
	private int count;
	@NotNull(message="order must have a book")
	private Book book;
	
	public OrderBookCount() {}
	public OrderBookCount(int count, Book book) {
		this.count = count;
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
