package com.getir.readingisgood.services;

import com.getir.readingisgood.modal.Book;

public interface IBookService {

	public Book addBook(Book book);
	public Book updateStock(long id, int newStockCount);
}
