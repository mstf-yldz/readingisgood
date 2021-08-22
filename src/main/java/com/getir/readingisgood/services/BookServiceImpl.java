package com.getir.readingisgood.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.data.BookRepository;
import com.getir.readingisgood.modal.Book;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	public Book addBook(Book book) {
		book.setId(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
		return bookRepository.save(book);
	}
	
	@Override
	public Book updateStock(long id, int newStockCount) {
		Optional<Book> bookOpt = bookRepository.findById(id);
		if(bookOpt.isPresent()) {
			Book book = bookOpt.get();
			book.setStockCount(newStockCount);
			return bookRepository.save(book);
		}
		return null;
	}

}
