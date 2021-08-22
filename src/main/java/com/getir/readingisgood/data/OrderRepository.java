package com.getir.readingisgood.data;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.getir.readingisgood.modal.Customer;
import com.getir.readingisgood.modal.Order;

public interface OrderRepository extends MongoRepository<Order, Long>{

	<S extends Order> S save(S order);
	List<Order> findByCustomer(Customer customer, Pageable pageable);
	List<Order> findByOrderDateBetween(LocalDateTime from, LocalDateTime to);
}
