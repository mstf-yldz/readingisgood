package com.getir.readingisgood.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.getir.readingisgood.modal.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long>{

	<S extends Customer> S save(S customer);
}
