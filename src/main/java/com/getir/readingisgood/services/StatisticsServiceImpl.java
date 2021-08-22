package com.getir.readingisgood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.modal.Order;
import com.getir.readingisgood.modal.Statistics;

@Service
public class StatisticsServiceImpl implements IStatisticsService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Statistics> stats() {
		GroupOperation group = Aggregation.group("orderDate").count().as("totalOrderCount").sum("totalAmount").as("totalPurchasedOrderAmount");
		TypedAggregation<Order> aggregation = Aggregation.newAggregation(Order.class,group);
		AggregationResults<Statistics> results = mongoTemplate.aggregate(aggregation, "order", Statistics.class);
		return results.getMappedResults();
	}
	

}
