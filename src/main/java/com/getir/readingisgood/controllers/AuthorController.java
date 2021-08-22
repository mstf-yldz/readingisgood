package com.getir.readingisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.modal.Author;
import com.getir.readingisgood.services.IAuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private IAuthorService authorService;
	
	@PostMapping(path="/add")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		return new ResponseEntity<Author>(authorService.addAuthor(author),HttpStatus.CREATED);
	}
}
