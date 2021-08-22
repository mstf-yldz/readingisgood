package com.getir.readingisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.modal.Publisher;
import com.getir.readingisgood.services.IPublisherService;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

	@Autowired
	private IPublisherService publisherService;
	
	@PostMapping(path="/add")
	public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher) {
		return new ResponseEntity<Publisher>(publisherService.addPublisher(publisher),HttpStatus.CREATED);
		
	}
}
