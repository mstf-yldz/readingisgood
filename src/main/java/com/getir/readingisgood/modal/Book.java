package com.getir.readingisgood.modal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Book {

	public static final String SEQUENCE_NAME = "book_sequence";
	
	@Id
	private long id;
	@NotNull
	@Size(min=2, max=100)
	private String title;
	@DBRef
	private Author author;
	@DBRef 
	private Publisher publisher;
	@NotNull
	@Min(1)
	private double price;
	@NotNull
	@Min(1)
	private int stockCount;
	private boolean isInOrderProcess;
	
	public Book() {}

	public Book(String title, Author author, Publisher publisher, double price, int stockCount) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.stockCount = stockCount;
		this.isInOrderProcess = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public boolean isInOrderProcess() {
		return isInOrderProcess;
	}

	public void setInOrderProcess(boolean isInOrderProcess) {
		this.isInOrderProcess = isInOrderProcess;
	}
	
	
	
	// TODO toString override
}
