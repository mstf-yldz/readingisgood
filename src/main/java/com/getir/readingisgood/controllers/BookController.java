package com.getir.readingisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.modal.Book;
import com.getir.readingisgood.services.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@PostMapping(path="/add",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.addBook(book),HttpStatus.CREATED);
	}
	
	@PutMapping(path="updateStock/{id}/{newStockCount}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBookStockCount(@PathVariable long id, @PathVariable int newStockCount) {
		return new ResponseEntity<Book>(bookService.updateStock(id, newStockCount),HttpStatus.CREATED);
	}
}
