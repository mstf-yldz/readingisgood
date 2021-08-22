package com.getir.readingisgood.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.modal.Order;
import com.getir.readingisgood.services.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@PostMapping(path="/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.placeOrder(order),HttpStatus.CREATED);
	}
	
	@GetMapping(path="/get/{id}")
	public ResponseEntity<Order> get(@PathVariable long id) {
		return new ResponseEntity<Order>(orderService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping(path="/list/{start}/{end}")
	public ResponseEntity<List<Order>> listOrdersByOrderDateBetween(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime start, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime end){
		return new ResponseEntity<List<Order>>(orderService.findByOrderDateBetween(start,end),HttpStatus.OK);
	}
}
