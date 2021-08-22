package com.getir.readingisgood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.readingisgood.modal.Statistics;
import com.getir.readingisgood.services.IStatisticsService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	IStatisticsService statisticsService;
	
	@GetMapping(path="/stats")
	public ResponseEntity<List<Statistics>> getTotalAmountOfPurchasedOrders() {
		return new ResponseEntity<List<Statistics>>(statisticsService.stats(),HttpStatus.OK);
	}
}
